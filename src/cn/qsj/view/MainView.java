package cn.qsj.view;


import java.util.List;
import java.util.Scanner;

import cn.qsj.service.ZhangWuService;

import cn.qsj.domain.ZhangWu;

public class MainView {
	
		//本项目中的view依赖service
		private ZhangWuService zhangWuService = new ZhangWuService();
		
		public void run() {
			
			//1.打印菜单2.获取用户输入3.调用对应方法
			
			boolean flag = true;
			
			Scanner in = new Scanner(System.in);
			 while(flag) {
				 System.out.println("-------------------轻松记--------------------");
				 System.out.println("1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统");
				 System.out.println("请输入要操作的序号[1-5]");
				 int op = in.nextInt();
				 
				 switch(op) {

				 case 1:
					  addZhangWu();
					  break;
					  
				 case 2:
					  editZhangWu();
					  break;
					  
				 case 3:
					  deleteZhangWu();
					  break;
					  
				 case 4:
					  selectZhangWu();
					  break;	
					  
				 case 5:
					  System.out.println("再见！");
					  flag = false;
					  break;
					  
			     default:
			    	 System.out.println("输入错误！");
			  
					  
			     
				 }
			 }
		}
		
		public void selectZhangWu() {
			System.out.println("1.查询所有 2.按条件查询");
			
			Scanner in = new Scanner(System.in);
			
			int op = in.nextInt();
			
			switch(op) {
			
			case 1:
				selectAll();
				break;
				
			case 2:
				select();
				break;
				
			default:
				System.out.println("输入错误");
			}
		}
		
		//查询所有账务的方法
		public void selectAll() {
			List<ZhangWu> zhangWuList = zhangWuService.selectAll();
			print(zhangWuList);
			
		}

		private void print(List<ZhangWu> zhangWuList) {
			// TODO Auto-generated method stub
			System.out.println("ID\t\t金额\t\t说明\t\t时间");
			for(ZhangWu zw:zhangWuList) {
				
				System.out.println(zw.getId()+"\t"+zw.getMoney()+"\t\t"
						+zw.getCreatetime()+"\t\t"+zw.getDescription());
			}
			
			
		}
		
		public void select() {
			/*
			 * 1. 获取用户输入查询日期范围。 
			 * 2. 调用service的select()方法完成条件查询功能
			 */
			Scanner in = new Scanner(System.in);
			System.out.print("请输入查询起始时间：");
			String start = in.next();
			System.out.print("请输入查询结束时间：");
			String end = in.next();
			List<ZhangWu> zhangWuList = zhangWuService.select(start, end);
			print(zhangWuList);
		}
		
		public void addZhangWu() {
			/*
			 * 1. 获取用户输入，封装到bean中。 
			 * 2. 调用service的addZhangWu()方法完成添加功能
			 */
			Scanner in = new Scanner(System.in);
			ZhangWu zw = new ZhangWu();
			
			System.out.print("请输入金额：");
			zw.setMoney(in.nextDouble());
			
			System.out.print("请输入说明：");
			zw.setDescription(in.next());
			
			System.out.print("请输入时间：");
			zw.setCreatetime(in.next());
			
			zhangWuService.addZhangWu(zw);
			System.out.println("添加账务成功！");
		}
		
		public void editZhangWu() {
			/*
			 * 1. 获取用户输入，封装到bean中。 
			 * 2. 调用service的editZhangWu()方法完成添加功能
			 */
			Scanner in = new Scanner(System.in);
			ZhangWu zw = new ZhangWu();
			System.out.print("请输入ID：");
			zw.setId(in.nextInt());
			
			System.out.print("请输入新金额：");
			zw.setMoney(in.nextDouble());
			
			System.out.print("请输入新说明：");
			zw.setDescription(in.next());
			
			System.out.print("请输入新时间：");
			zw.setCreatetime(in.next());
			
			zhangWuService.editZhangWu(zw);
			System.out.println("编辑账务成功！");
		}
		
		public void deleteZhangWu() {
			/*
			 * 1. 获取用户输入，封装到bean中。 
			 * 2. 调用service的deleteZhangWu()方法完成添加功能
			 */
			Scanner in = new Scanner(System.in);
			System.out.print("请输入ID：");
			
			zhangWuService.deleteZhangWu(in.nextInt());
			System.out.println("删除账务成功！");
		}
	
}
