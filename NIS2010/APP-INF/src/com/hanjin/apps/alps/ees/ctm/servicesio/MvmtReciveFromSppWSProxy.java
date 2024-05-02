/*========================================================
 *Copyright(c) 2009 CyberLogitec 
 *ProcessChain    : NPI
 *@FileName       : MvmtReciveFromSppWSProxy.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Feb 16, 2009
 *@LastModifier   : Jeong-Hoon, KIM
 *@LastVersion    : 1.0
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.servicesio;


import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.EquipmentMovementMgtSC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0999Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * It's MvmtReciveFromSppWSProxy.java
 * @author KyungMin, Woo
 * @see
 * @since J2EE 1.5
 * Feb 23, 2009
 */
@WebService(name="MvmtReciveFromSppProxyPortType", serviceName="MvmtReciveFromSppProxy", targetNamespace="http://www.hanjin.com/integration/schedule")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/MvmtReciveFromSppProxy", portName="MvmtReciveFromSppProxyPort")
public class MvmtReciveFromSppWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * manageSppMovement for MvmtReciveFromSppWSProxy
	 *
	 * @author KyungMin, Woo
	 * @param  CusCtmMovementVO[] cusCtmMovementVOS
	 * @return String[][]
	 */
	@WebMethod()
	public String[][] manageSppMovement(CusCtmMovementVO[] cusCtmMovementVOS) {

		String[][] list = new String[cusCtmMovementVOS.length][3];
		EquipmentMovementMgtSC sc = new EquipmentMovementMgtSC();
		Event event = new EesCtm0999Event(cusCtmMovementVOS);

		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.MULTI);
		event.setFormCommand(f);
		try {
			Map rtnMap = new HashMap();
			EventResponse rtn = sc.perform(event);
			rtnMap = rtn.getETCData();
			String rtnStr = (String) rtnMap.get("rtnStr");
			String[] result = new String[cusCtmMovementVOS.length + 1];
			String tmpStr = rtnStr;

			for (int id = 0; id < cusCtmMovementVOS.length + 1; id++) {
				log.info("\n\n===============================================================" +
						  "\n SPP : cusCtmMovementVOS[" + id + "] : ColumnValues" +
						  "\n======================================" +
						  "\n" + cusCtmMovementVOS[id].getColumnValues().toString().replaceAll(", ", "\n") +
						  "\n===============================================================\n");
				int idxOf = tmpStr.indexOf("^^");
				result[id] = tmpStr.substring(0, idxOf);
				tmpStr = tmpStr.substring(idxOf+2, tmpStr.length());
				if (tmpStr.length() <= 2) break;
			}

			for (int ix = 0; ix < result.length-1; ix++) {
				if (result[ix] == null || result[ix].equals("null") || result[ix].equals("")) {
					list[ix][0] = cusCtmMovementVOS[ix].getCntrNo();
					list[ix][1] = "Y";
					list[ix][2] = "";
				} else {
					list[ix][0] = cusCtmMovementVOS[ix].getCntrNo();
					list[ix][1] = "N";
					log.info("Result :" + result[ix]);
					list[ix][2] = result[ix];
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
		}

		return list;
	}

}
