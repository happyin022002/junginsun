/**
 * Copyright(c) 2013 CyberLogitec
 * ProcessChain    : CUP
 * @FileName       : Sap0050001ReceiveWSProxy.java
 * @FileTitle      : Homepage Admin에서 메뉴별 접근 권한 ALPS로 I/F
 * @Author         : Sang-Hyun Kim
 * Open Issues     :
 * Change history  :
 * @LastModifyDate : 2013.12.16
 * @LastModifier   : Sang-Hyun Kim
 * @LastVersion    : 1.0
 * 2013.12.16 1.0 Sang-Hyun Kim Creation.
 */
package com.hanjin.apps.alps.common.mobile.servicesio;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.common.mobile.hansap.HansapSC;
import com.hanjin.apps.alps.common.mobile.hansap.event.MenuAccessEvent;
import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.SAP0050001Document;
import com.hanjin.irep.alpsws.SAP0050001Document.SAP0050001;
import com.hanjin.irep.alpsws.SAP0050001Document.SAP0050001.DataArea;
import com.hanjin.irep.alpsws.SAP0050001Document.SAP0050001.DataArea.ADMCollection;
import com.hanjin.irep.alpsws.SAP0050001Document.SAP0050001.DataArea.ADMCollection.ADMRequest;
import com.hanjin.irep.alpsws.SAP0050001Document.SAP0050001.DataArea.ADMCollection.ADMResponse;

import weblogic.jws.WLHttpTransport;

@WebService(name="Sap0050001ReceiveWSProxyPortType", serviceName="Sap0050001ReceiveWSProxy", targetNamespace="http://irep.hanjin.com/alpsws")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Sap0050001ReceiveWSProxy", portName="Sap0050001ReceiveWSProxyPort")

/**
 * Sap0050001ReceiveWSProxy
 * @author Sang-Hyun Kim
 * @see
 * @since J2SE 1.6
 * 2013.12.16
 */
public class Sap0050001ReceiveWSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * 'MOB_AUTHORITY' HANSAP 메뉴별 접근 권한 추가, 삭제 처리
	 * @param sap0050001Document
	 * @return String
	 */
	@WebMethod()
	public String sap0050001ReceiveWS(SAP0050001Document sap0050001Document) {
		String result = "Y";
		HansapSC hansapSC = new HansapSC();

		try {
			if (sap0050001Document == null || sap0050001Document.equals("")) {
				throw new EventException("Parameter is not valided !");
			}
			log.info("\r\n>>> SAP005_0001 EAI Start.");

			SAP0050001 sap0050001 = sap0050001Document.getSAP0050001();
			DataArea dataArea = sap0050001.getDataArea();
			ADMCollection admCollection = dataArea.getADMCollection();
			ADMRequest admRequests[] = admCollection.getADMRequestArray();
			ADMResponse admResponse = admCollection.getADMResponse();

			ArrayList<MobAuthorityVO> addList = new ArrayList<MobAuthorityVO>();
			ArrayList<MobAuthorityVO> removeList = new ArrayList<MobAuthorityVO>();
			for (ADMRequest admRequest : admRequests) {
				MobAuthorityVO mobAuthorityVO = new MobAuthorityVO();
				mobAuthorityVO.setIbflag(admRequest.getIbFlag());
				mobAuthorityVO.setMnuId(admRequest.getMnuId());
				mobAuthorityVO.setUsrId(admRequest.getUsrId());
				mobAuthorityVO.setCreUsrId(admRequest.getCreUsrId());
				mobAuthorityVO.setUpdUsrId(admRequest.getUpdUsrId());

				log.info("\r\n>>> Request : " + admRequest);

				if (admRequest.getIbFlag().equals("I")) {
					addList.add(mobAuthorityVO);
				} else if (admRequest.getIbFlag().equals("D")) {
					removeList.add(mobAuthorityVO);
				}
			}

			// Menu 접근 삭제.
			if (removeList.size() > 0) {
				MobAuthorityVO removeVos[] = new MobAuthorityVO[removeList.size()];
				removeList.toArray(removeVos);

				FormCommand formCommand = new FormCommand();
				formCommand.setCommand(FormCommand.REMOVE);
				MenuAccessEvent event = new MenuAccessEvent();
				event.setFormCommand(formCommand);
				event.setMobAuthorityVOs(removeVos);

				hansapSC.perform(event);
			}

			// Menu 접근 추가.
			if (addList.size() > 0) {
				MobAuthorityVO addVos[] = new MobAuthorityVO[addList.size()];
				addList.toArray(addVos);

				FormCommand formCommand = new FormCommand();
				formCommand.setCommand(FormCommand.ADD);
				MenuAccessEvent event = new MenuAccessEvent();
				event.setFormCommand(formCommand);
				event.setMobAuthorityVOs(addVos);

				hansapSC.perform(event);
			}

			if (admResponse != null) {
				admResponse.setMobAuthScsFlg(result);
			}
			log.info("\r\n>>> SAP005_0001 EAI End.");
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage());
			result = "N";
		}

		return result;
	}
}
