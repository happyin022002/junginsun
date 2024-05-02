/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageDBDAO.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 
*@LastModifyDate : 2006-12-26
*@LastModifier : Jeong-seon An
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.enisEsd.EAIHeaderType;
import com.clt.irep.enisEsd.ESD0220001Document;
import com.clt.irep.enisEsd.ESD0220001Document.ESD0220001;
import com.clt.irep.enisEsd.ESD0220001Document.ESD0220001.DataArea.BKGSTSCollection;
import com.clt.irep.enisEsd.ESD0220001Document.ESD0220001.DataArea.BKGSTSCollection.BKGSTSRequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.ws.AxDocClient;

/**
 * SCE에 대한 EAI 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Moon-Young Lee
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class COPSearchEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / <br>
	 * Booking Document정보를 수신한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String bkg_no_split
	 * @param String bl_no
	 * @return Collection
	 * @throws DAOException
     * . Request and Reply 인 Synchronous Type 의 프로세스에서는 EAI 차원에서의 
     *   Exception/Retry 를 수행하지 않습니다. ( Exception 처리를 하게되면, 호출한 Web Service Process 에서는
     *   결과 Return 을 수신하지 못하고 Timeout 에 걸릴 우려가 있기 때문 입니다. )
     *   <xsd:element name="BKGSTSResponse" maxOccurs="unbounded"> 항목의 EAI_RESULT 에 'OK' 를 반환 합니다.
     * . 만일, invoke 할 때에 timeout 이나 기타 에러 등이 발생될 때에는 EAI_RESULT 에 
     *   발생된 해당 에러 메시지를 그대로 반환 합니다.
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection transferAtOnceSCE01ToEAIByWS(String bkg_no, String bkg_no_split, String bl_no) throws DAOException {
		Collection models = null;
		TransferEAI eai = null;
		String msg = "";
		
		try{
			
			log.debug("\n Parameter Marshalling Start!!-------------------");
			String target =  SubSystemConfigFactory.get("SCE.ESD0220001.URL");
			String datetime =  "ESD0220001H"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			String headtitle = "ESD0220001--Header";
			
			ESD0220001Document docReq = ESD0220001Document.Factory.newInstance();
			ESD0220001 esd0220001Req = ESD0220001.Factory.newInstance();
			EAIHeaderType hearderTypeReq = esd0220001Req.addNewEAIHeader();
			hearderTypeReq.setInstanceId(datetime);
            EAIHeaderType.Parameters params = hearderTypeReq.addNewParameters();
            EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            param.setStringValue(headtitle);
	
            ESD0220001.DataArea dataAreaReq = esd0220001Req.addNewDataArea();
			BKGSTSCollection collectionReq = dataAreaReq.addNewBKGSTSCollection();
			BKGSTSRequest bkgStsReq = collectionReq.addNewBKGSTSRequest();
			
			bkgStsReq.setBKGNO(bkg_no);
			bkgStsReq.setBKGNOSPLIT(bkg_no_split);
			bkgStsReq.setBLNO(bl_no);

			dataAreaReq.setBKGSTSCollection(collectionReq);
			esd0220001Req.setDataArea(dataAreaReq);
			docReq.setESD0220001(esd0220001Req);
			
			log.debug( "\n" + docReq.toString() );
	
	        eai = new AxDocClient(target, this.getClass());
	        eai.setMessage(docReq.toString());
	        
	        msg = eai.commit(hearderTypeReq.getInstanceId()); 
			
			log.debug( "\n bkg_no " + bkg_no );
			log.debug( "\n bkg_no_split " + bkg_no_split );
			log.debug( "\n bl_no " + bl_no );
			log.debug( "\n docReq " + docReq.toString() );

			log.debug("\n Unmarshalling Response Result Start!!-------------------");
			ESD0220001Document docRes = ESD0220001Document.Factory.parse(msg);
			ESD0220001 esd0220001Res = docRes.getESD0220001();
			
			ESD0220001.DataArea dataAreaRes = esd0220001Res.getDataArea(); 
			ESD0220001.DataArea.BKGSTSCollection collectionRes = dataAreaRes.getBKGSTSCollection();
			ESD0220001.DataArea.BKGSTSCollection.BKGSTSResponse[] eaiModelArr = 
				collectionRes.getBKGSTSResponseArray();
			
			models = new ArrayList();  
	
			for ( int i=0; eaiModelArr!=null && i<eaiModelArr.length; i++){
				HashMap map = new HashMap();
				
				map.put("DBL_LOG_UPDT_DT", eaiModelArr[i].getDBLLOGUPDTDT());
				map.put("AN_LOG_UPDT_DT",  eaiModelArr[i].getANLOGUPDTDT());
				map.put("ISS_DT", 	       eaiModelArr[i].getISSDT());
				map.put("BCO_DATE", 	   eaiModelArr[i].getBCODATE());
				map.put("EAI_RESULT", 	   eaiModelArr[i].getEAIRESULT());
					
				models.add( map );

				log.debug( "\n" + docRes.toString() );
			}
	
		}  catch (Exception e) {
			eai.rollback(e);
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } 
		eai.close();
		
		return models;	
	}
}