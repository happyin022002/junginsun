/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryEspReportBackEndJob.java
*@FileTitle : EES_CGM_1115 BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.01 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration.ChassisMgsetInventoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt EES_CGM_1115 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chae-Shung Cho
 * @see ChassisMgsetInventoryEspReportBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInventoryEspReportBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInventoryDBDAO dbDao;

	private CHSEspReportINVO cHSEspReportINVO;

	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1115] <br>
	 *  
	 * @param cHSEspReportINVO CHSEspReportINVO 
	 * @return void
	 * @exception EventException
	 */		
	public void setCHSEspReportINVO(CHSEspReportINVO cHSEspReportINVO) {
		this.cHSEspReportINVO = cHSEspReportINVO;
	}

	
	/**
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 BACKEND로 조회  [EES_CGM_1115] <br>
	 *  
	 * @return List<CHSEspReportMGTVO>
	 * @exception EventException
	 */	
	public List<CHSEspReportMGTVO> doStart() throws Exception
	{
		//searchCHSEspReportBasic => doStart
		this.dbDao = new ChassisMgsetInventoryDBDAO();
		try {
			String tmp_throughput_inq_fm_dys = cHSEspReportINVO.getTroughputInqFmDys();
			String tmp_throughput_inq_to_dys = cHSEspReportINVO.getTroughputInqToDys();
			tmp_throughput_inq_fm_dys = tmp_throughput_inq_fm_dys.replaceAll("-", "");
			tmp_throughput_inq_to_dys = tmp_throughput_inq_to_dys.replaceAll("-", "");
			cHSEspReportINVO.setTroughputInqFmDys(tmp_throughput_inq_fm_dys);
			cHSEspReportINVO.setTroughputInqToDys(tmp_throughput_inq_to_dys);
			
			String tmp_turntime_inq_fm_dys = cHSEspReportINVO.getTurnTimeInqFmDys();
			String tmp_turntime_inq_to_dys = cHSEspReportINVO.getTurnTimeInqToDys();
			tmp_turntime_inq_fm_dys = tmp_turntime_inq_fm_dys.replaceAll("-", "");
			tmp_turntime_inq_to_dys = tmp_turntime_inq_to_dys.replaceAll("-", "");
			cHSEspReportINVO.setTurnTimeInqFmDys(tmp_turntime_inq_fm_dys);
			cHSEspReportINVO.setTurnTimeInqToDys(tmp_turntime_inq_to_dys);
			
			//return dbDao.searchCHSEspReportData(cHSEspReportINVO);
			
			List<CHSEspReportMGTVO> resultFirst = dbDao.searchCHSEspReportData(cHSEspReportINVO);
			List<CHSEspReportMGTVO> resultCalc = new ArrayList<CHSEspReportMGTVO>();
			
			CHSEspReportMGTVO cHSEspReportMGTVORow[] = new CHSEspReportMGTVO[31]; 
			for(int i=0; i<31; i++)
			{
				cHSEspReportMGTVORow[i] = new CHSEspReportMGTVO();
				cHSEspReportMGTVORow[i].setT20("0");
				cHSEspReportMGTVORow[i].setT40("0");
				cHSEspReportMGTVORow[i].setT45("0");
				cHSEspReportMGTVORow[i].setR5("0");
			}
			cHSEspReportMGTVORow[0].setGubun("Import");
			cHSEspReportMGTVORow[1].setGubun("Import");
			cHSEspReportMGTVORow[2].setGubun("Import");
			cHSEspReportMGTVORow[3].setGubun("Import");
			cHSEspReportMGTVORow[4].setGubun("Import");
			cHSEspReportMGTVORow[5].setGubun("Import");
			cHSEspReportMGTVORow[6].setGubun("Import");
			cHSEspReportMGTVORow[0].setSubj("Import Quarterly Throughput (Box)");
			cHSEspReportMGTVORow[1].setSubj("Import Weekly Throughput (Box)");
			cHSEspReportMGTVORow[2].setSubj("Turn Time IC-ID (Day)");
			cHSEspReportMGTVORow[3].setSubj("Turn Time ID-MT (Day)");
			cHSEspReportMGTVORow[4].setSubj("Import Turn Time Adjustment (Day)");
			cHSEspReportMGTVORow[5].setSubj("Import Turn Time Total (Day)");
			cHSEspReportMGTVORow[6].setSubj("Chassis Requirement - Import Subtotal (Unit)");
			
			cHSEspReportMGTVORow[7].setGubun("Export");
			cHSEspReportMGTVORow[8].setGubun("Export");
			cHSEspReportMGTVORow[9].setGubun("Export");
			cHSEspReportMGTVORow[10].setGubun("Export");
			cHSEspReportMGTVORow[11].setGubun("Export");
			cHSEspReportMGTVORow[12].setGubun("Export");
			cHSEspReportMGTVORow[13].setGubun("Export");
			cHSEspReportMGTVORow[14].setGubun("Export");
			cHSEspReportMGTVORow[7].setSubj("Export Quarterly Throughput (Box)");
			cHSEspReportMGTVORow[8].setSubj("Export Weekly Throughput (Box)");
			cHSEspReportMGTVORow[9].setSubj("Turn Time MT-OP (Day)");
			cHSEspReportMGTVORow[10].setSubj("Turn Time OP-OC (Day)");
			cHSEspReportMGTVORow[11].setSubj("Turn Time OC-EN (Day)");
			cHSEspReportMGTVORow[12].setSubj("Export Turn Time Adjustment (Day)");
			cHSEspReportMGTVORow[13].setSubj("Export Turn Time Total (Day)");
			cHSEspReportMGTVORow[14].setSubj("Chassis Requirement - Export Subtotal (Unit)");
			
			cHSEspReportMGTVORow[15].setGubun("Empty");
			cHSEspReportMGTVORow[16].setGubun("Empty");
			cHSEspReportMGTVORow[17].setGubun("Empty");
			cHSEspReportMGTVORow[18].setGubun("Empty");
			cHSEspReportMGTVORow[19].setGubun("Empty");
			cHSEspReportMGTVORow[20].setGubun("Empty");
			cHSEspReportMGTVORow[15].setSubj("Empty Quarterly Throughput (Box)");
			cHSEspReportMGTVORow[16].setSubj("Empty Weekly Throughput (Box)");
			cHSEspReportMGTVORow[17].setSubj("Turn Time MT-EN (Day)");
			cHSEspReportMGTVORow[18].setSubj("Empty Turn Time Adjustment (Day)");
			cHSEspReportMGTVORow[19].setSubj("Empty Turn Time Total (Day)");
			cHSEspReportMGTVORow[20].setSubj("Chassis Requirement - Empty Subtotal (Unit)");
			
			cHSEspReportMGTVORow[21].setGubun("Domestic");
			cHSEspReportMGTVORow[22].setGubun("Domestic");
			cHSEspReportMGTVORow[23].setGubun("Domestic");
			cHSEspReportMGTVORow[24].setGubun("Domestic");
			cHSEspReportMGTVORow[21].setSubj("Domestic Quarterly Throughput (Box)");
			cHSEspReportMGTVORow[22].setSubj("Domestic Weekly Throughput (Box)");
			cHSEspReportMGTVORow[23].setSubj("Dometic Turn Time Adjustment (Day)");
			cHSEspReportMGTVORow[24].setSubj("chassis requirement - Domestic subtotal (Unit)");
			
			cHSEspReportMGTVORow[25].setGubun("Chassis Requirement - Grand Total (Unit)");
			cHSEspReportMGTVORow[26].setGubun("Maintenance and Repair Factor (%)");
			cHSEspReportMGTVORow[27].setGubun("Sales Volume Increase Factor (%)");
			cHSEspReportMGTVORow[28].setGubun("Utilization Factor (%)");
			cHSEspReportMGTVORow[29].setGubun("Other Factors (%)");
			cHSEspReportMGTVORow[30].setGubun("Final Adjusted Chassis ESP (Unit)");
			cHSEspReportMGTVORow[25].setSubj("Chassis Requirement - Grand Total (Unit)");
			cHSEspReportMGTVORow[26].setSubj("Maintenance and Repair Factor (%)");
			cHSEspReportMGTVORow[27].setSubj("Sales Volume Increase Factor (%)");
			cHSEspReportMGTVORow[28].setSubj("Utilization Factor (%)");
			cHSEspReportMGTVORow[29].setSubj("Other Factors (%)");
			cHSEspReportMGTVORow[30].setSubj("Final Adjusted Chassis ESP (Unit)");
			
			CHSEspReportMGTVO tmpM = new CHSEspReportMGTVO();
			tmpM.setT20("0");
			tmpM.setT40("0");
			tmpM.setT45("0");
			tmpM.setR5("0");
			tmpM.setMdiff("1"); //Null Pointer Exception.
								//200910~200910  같은 날짜를 입력하였을 경우 mdiff == 1 이고
								//데이터가 없을 경우 어차피 분자가 0이 되므로 mdiff == 1이어도 무방하다.
								//따라서, Mdiff(월간격)의 기본값은 1로 한다. 
			
			for(int i=0; i< resultFirst.size(); i++)
			{
				CHSEspReportMGTVO tmp = (CHSEspReportMGTVO)resultFirst.get(i);
				if(tmp.getT20().equals(""))	tmp.setT20("0");
				if(tmp.getT40().equals(""))	tmp.setT40("0");
				if(tmp.getT45().equals(""))	tmp.setT45("0");
				if(tmp.getR5().equals(""))	tmp.setR5("0");
				
				if(tmp.getSubj().equals("FI"))
				{
					//cHSEspReportMGTVORow[0].setSubj("Import Quarterly Throughput(Box)");
					//cHSEspReportMGTVORow[1].setSubj("Import Weekly Throughput(Box)");
					double dT20 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT20()))) ;
					double dT40 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT40()))) ;
					double dT45 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT45()))) ;
					double dR5 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getR5()))) ;
					double mdiff = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getMdiff())));
					
					//Querterly
					String dQT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT20/mdiff*3)))).toString();
					String dQT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT40/mdiff*3)))).toString();
					String dQT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT45/mdiff*3)))).toString();
					String dQR5 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dR5/mdiff*3)))).toString();
					cHSEspReportMGTVORow[0].setT20(dQT20);
					cHSEspReportMGTVORow[0].setT40(dQT40);
					cHSEspReportMGTVORow[0].setT45(dQT45);
					cHSEspReportMGTVORow[0].setR5(dQR5);
					//Weekly
					String dWWT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT20/mdiff*3)/13)))).toString();
					String dWWT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT40/mdiff*3)/13)))).toString();
					String dWWT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT45/mdiff*3)/13)))).toString();
					String dWWR5  = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(( dR5/mdiff*3)/13)))).toString();
					cHSEspReportMGTVORow[1].setT20(dWWT20);
					cHSEspReportMGTVORow[1].setT40(dWWT40);
					cHSEspReportMGTVORow[1].setT45(dWWT45);
					cHSEspReportMGTVORow[1].setR5(dWWR5);
				}else if(tmp.getSubj().equals("FO"))
				{
					//cHSEspReportMGTVORow[7].setSubj("Export Quarterly Throughput(Box)");
					//cHSEspReportMGTVORow[8].setSubj("Export Weekly Throughput(Box)");				
					double dT20 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT20()))) ;
					double dT40 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT40()))) ;
					double dT45 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT45()))) ;
					double dR5 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getR5()))) ;
					double mdiff = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getMdiff())));
					
					//Querterly
					String dQT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT20/mdiff*3)))).toString();
					String dQT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT40/mdiff*3)))).toString();
					String dQT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT45/mdiff*3)))).toString();
					String dQR5 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dR5/mdiff*3)))).toString();
					cHSEspReportMGTVORow[7].setT20(dQT20);
					cHSEspReportMGTVORow[7].setT40(dQT40);
					cHSEspReportMGTVORow[7].setT45(dQT45);
					cHSEspReportMGTVORow[7].setR5(dQR5);
					//Weekly
					String dWWT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT20/mdiff*3)/13)))).toString();
					String dWWT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT40/mdiff*3)/13)))).toString();
					String dWWT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT45/mdiff*3)/13)))).toString();
					String dWWR5  = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(( dR5/mdiff*3)/13)))).toString();
					cHSEspReportMGTVORow[8].setT20(dWWT20);
					cHSEspReportMGTVORow[8].setT40(dWWT40);
					cHSEspReportMGTVORow[8].setT45(dWWT45);
					cHSEspReportMGTVORow[8].setR5(dWWR5);			
				}else if(tmp.getSubj().equals("MI"))
				{
					//cHSEspReportMGTVORow[15].setSubj("Empty Quarterly Throughput(Box)");
					//cHSEspReportMGTVORow[16].setSubj("Empty Weekly Throughput(Box)");		
					tmpM.setT20(Integer.valueOf(Integer.valueOf(tmpM.getT20())+ Integer.valueOf(tmp.getT20())).toString());
					tmpM.setT40(Integer.valueOf(Integer.valueOf(tmpM.getT40())+ Integer.valueOf(tmp.getT40())).toString());
					tmpM.setT45(Integer.valueOf(Integer.valueOf(tmpM.getT45())+ Integer.valueOf(tmp.getT45())).toString());
					tmpM.setR5(Integer.valueOf(Integer.valueOf(tmpM.getR5())+ Integer.valueOf(tmp.getR5())).toString());
					tmpM.setMdiff(tmp.getMdiff());
				}else if(tmp.getSubj().equals("MO"))
				{
					//cHSEspReportMGTVORow[15].setSubj("Empty Quarterly Throughput(Box)");
					//cHSEspReportMGTVORow[16].setSubj("Empty Weekly Throughput(Box)");					
					tmpM.setT20(Integer.valueOf(Integer.valueOf(tmpM.getT20())+ Integer.valueOf(tmp.getT20())).toString());
					tmpM.setT40(Integer.valueOf(Integer.valueOf(tmpM.getT40())+ Integer.valueOf(tmp.getT40())).toString());
					tmpM.setT45(Integer.valueOf(Integer.valueOf(tmpM.getT45())+ Integer.valueOf(tmp.getT45())).toString());
					tmpM.setR5(Integer.valueOf(Integer.valueOf(tmpM.getR5())+ Integer.valueOf(tmp.getR5())).toString());
					tmpM.setMdiff(tmp.getMdiff());
				}else if(tmp.getSubj().equals("TURNTIME"))
				{
					//cHSEspReportMGTVORow[2].setSubj("Turn Time IC-ID(Day)");   C
					//cHSEspReportMGTVORow[3].setSubj("Turn Time ID-MT(Day)"); 	 D
					//cHSEspReportMGTVORow[9].setSubj("Turn Time MT-OP(Day)");	 H
					//cHSEspReportMGTVORow[10].setSubj("Turn Time OP-OC(Day)");	 I
					//cHSEspReportMGTVORow[11].setSubj("Turn Time OC-EN(Day)");	 J		
					//cHSEspReportMGTVORow[17].setSubj("Turn Time MT-EN (Day)"); E
					
					if(tmp.getMdiff().equals("C"))
					{
						cHSEspReportMGTVORow[2].setT20(tmp.getT20());
						cHSEspReportMGTVORow[2].setT40(tmp.getT40());
						cHSEspReportMGTVORow[2].setT45(tmp.getT45());
						cHSEspReportMGTVORow[2].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("D"))
					{
						cHSEspReportMGTVORow[3].setT20(tmp.getT20());
						cHSEspReportMGTVORow[3].setT40(tmp.getT40());
						cHSEspReportMGTVORow[3].setT45(tmp.getT45());
						cHSEspReportMGTVORow[3].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("H"))
					{
						cHSEspReportMGTVORow[9].setT20(tmp.getT20());
						cHSEspReportMGTVORow[9].setT40(tmp.getT40());
						cHSEspReportMGTVORow[9].setT45(tmp.getT45());
						cHSEspReportMGTVORow[9].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("I"))
					{
						cHSEspReportMGTVORow[10].setT20(tmp.getT20());
						cHSEspReportMGTVORow[10].setT40(tmp.getT40());
						cHSEspReportMGTVORow[10].setT45(tmp.getT45());
						cHSEspReportMGTVORow[10].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("J"))
					{
						cHSEspReportMGTVORow[11].setT20(tmp.getT20());
						cHSEspReportMGTVORow[11].setT40(tmp.getT40());
						cHSEspReportMGTVORow[11].setT45(tmp.getT45());
						cHSEspReportMGTVORow[11].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("E"))
					{
						cHSEspReportMGTVORow[17].setT20(tmp.getT20());
						cHSEspReportMGTVORow[17].setT40(tmp.getT40());
						cHSEspReportMGTVORow[17].setT45(tmp.getT45());
						cHSEspReportMGTVORow[17].setR5(tmp.getR5());
					}
					
				}else if(tmp.getSubj().equals("CGM_ESP_ADJ"))
				{
					//cHSEspReportMGTVORow[4].setSubj("Import Turn Time Adjustment(Day)");
					//cHSEspReportMGTVORow[12].setSubj("Export Turn Time Adjustment(Day)");
					//cHSEspReportMGTVORow[18].setSubj("Empty Turn Time Adjustment(Day)");
					//cHSEspReportMGTVORow[23].setSubj("Dometic Turn Time Adjustment(Day)");
					//cHSEspReportMGTVORow[25].setSubj("Maintenance and Repair Factor (%)");
					//cHSEspReportMGTVORow[26].setSubj("Sales Volume Increase Factor (%)");
					//cHSEspReportMGTVORow[27].setSubj("Utilization Factor (%)");
					//cHSEspReportMGTVORow[28].setSubj("Other Factors (%)");
					if(tmp.getMdiff().equals("A"))
					{
						cHSEspReportMGTVORow[4].setT20(tmp.getT20());
						cHSEspReportMGTVORow[4].setT40(tmp.getT40());
						cHSEspReportMGTVORow[4].setT45(tmp.getT45());
						cHSEspReportMGTVORow[4].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("B"))
					{
						cHSEspReportMGTVORow[12].setT20(tmp.getT20());
						cHSEspReportMGTVORow[12].setT40(tmp.getT40());
						cHSEspReportMGTVORow[12].setT45(tmp.getT45());
						cHSEspReportMGTVORow[12].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("C"))
					{
						cHSEspReportMGTVORow[18].setT20(tmp.getT20());
						cHSEspReportMGTVORow[18].setT40(tmp.getT40());
						cHSEspReportMGTVORow[18].setT45(tmp.getT45());
						cHSEspReportMGTVORow[18].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("D"))
					{
						cHSEspReportMGTVORow[23].setT20(tmp.getT20());
						cHSEspReportMGTVORow[23].setT40(tmp.getT40());
						cHSEspReportMGTVORow[23].setT45(tmp.getT45());
						cHSEspReportMGTVORow[23].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("E"))
					{
						cHSEspReportMGTVORow[26].setT20(tmp.getT20());
						cHSEspReportMGTVORow[26].setT40(tmp.getT40());
						cHSEspReportMGTVORow[26].setT45(tmp.getT45());
						cHSEspReportMGTVORow[26].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("F"))
					{
						cHSEspReportMGTVORow[27].setT20(tmp.getT20());
						cHSEspReportMGTVORow[27].setT40(tmp.getT40());
						cHSEspReportMGTVORow[27].setT45(tmp.getT45());
						cHSEspReportMGTVORow[27].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("G"))
					{
						cHSEspReportMGTVORow[28].setT20(tmp.getT20());
						cHSEspReportMGTVORow[28].setT40(tmp.getT40());
						cHSEspReportMGTVORow[28].setT45(tmp.getT45());
						cHSEspReportMGTVORow[28].setR5(tmp.getR5());
					}else if(tmp.getMdiff().equals("H"))
					{
						cHSEspReportMGTVORow[29].setT20(tmp.getT20());
						cHSEspReportMGTVORow[29].setT40(tmp.getT40());
						cHSEspReportMGTVORow[29].setT45(tmp.getT45());
						cHSEspReportMGTVORow[29].setR5(tmp.getR5());
					}
				}else if(tmp.getSubj().equals("DOM_BOOKING"))
				{
					//cHSEspReportMGTVORow[21].setSubj("Domestic Quarterly Throughput(Box)");
					//cHSEspReportMGTVORow[22].setSubj("Domestic Weekly Throughput(Box)");
					double dT20 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT20()))) ;
					double dT40 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT40()))) ;
					double dT45 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getT45()))) ;
					double dR5 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getR5()))) ;
					double mdiff = Double.parseDouble(String.format("%.2f", Double.valueOf(tmp.getMdiff())));
					
					//Querterly
					String dQT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT20/mdiff*3)))).toString();
					String dQT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT40/mdiff*3)))).toString();
					String dQT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT45/mdiff*3)))).toString();
					String dQR5 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dR5/mdiff*3)))).toString();
					cHSEspReportMGTVORow[21].setT20(dQT20);
					cHSEspReportMGTVORow[21].setT40(dQT40);
					cHSEspReportMGTVORow[21].setT45(dQT45);
					cHSEspReportMGTVORow[21].setR5(dQR5);
					//Weekly
					String dWWT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT20/mdiff*3)/13)))).toString();
					String dWWT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT40/mdiff*3)/13)))).toString();
					String dWWT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT45/mdiff*3)/13)))).toString();
					String dWWR5  = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(( dR5/mdiff*3)/13)))).toString();
					cHSEspReportMGTVORow[22].setT20(dWWT20);
					cHSEspReportMGTVORow[22].setT40(dWWT40);
					cHSEspReportMGTVORow[22].setT45(dWWT45);
					cHSEspReportMGTVORow[22].setR5(dWWR5);	
				}
			}
			//Throughput M처리
			//cHSEspReportMGTVORow[15].setSubj("Empty Quarterly Throughput(Box)");
			//cHSEspReportMGTVORow[16].setSubj("Empty Weekly Throughput(Box)");		
			double dT20 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmpM.getT20()))) ;
			double dT40 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmpM.getT40()))) ;
			double dT45 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmpM.getT45()))) ;
			double dR5 = Double.parseDouble(String.format("%.2f", Double.valueOf(tmpM.getR5()))) ;
			double mdiff = Double.parseDouble(String.format("%.2f", Double.valueOf(tmpM.getMdiff())));
			
			//Querterly
			String dQT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT20/mdiff*3)))).toString();
			String dQT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT40/mdiff*3)))).toString();
			String dQT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dT45/mdiff*3)))).toString();
			String dQR5 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(dR5/mdiff*3)))).toString();
			cHSEspReportMGTVORow[15].setT20(dQT20);
			cHSEspReportMGTVORow[15].setT40(dQT40);
			cHSEspReportMGTVORow[15].setT45(dQT45);
			cHSEspReportMGTVORow[15].setR5(dQR5);
			//Weekly
			String dWWT20 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT20/mdiff*3)/13)))).toString();
			String dWWT40 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT40/mdiff*3)/13)))).toString();
			String dWWT45 = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((dT45/mdiff*3)/13)))).toString();
			String dWWR5  = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(( dR5/mdiff*3)/13)))).toString();
			cHSEspReportMGTVORow[16].setT20(dWWT20);
			cHSEspReportMGTVORow[16].setT40(dWWT40);
			cHSEspReportMGTVORow[16].setT45(dWWT45);
			cHSEspReportMGTVORow[16].setR5(dWWR5);
			for(int i=0; i< cHSEspReportMGTVORow.length; i++)
			{
				resultCalc.add(cHSEspReportMGTVORow[i]);
			}
			return resultCalc;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
}