/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAR_MST_REV_VVDImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.tableSync.jms.integration.ReceiveQueueArMstRevVvdDBDAO;
import com.hanjin.framework.component.util.log4j.StringUtils;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0420001Document;
import com.hanjin.irep.erp.FNS0420001Document.FNS0420001;
import com.hanjin.irep.erp.FNS0420001Document.FNS0420001.DataArea;
import com.hanjin.irep.erp.FNS0420001Document.FNS0420001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0420001Document.FNS0420001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.ArMstRevVvdVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueArMstRevVvdBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueArMstRevVvdDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueArMstRevVvdBCImpl() {
		dbDao = new ReceiveQueueArMstRevVvdDBDAO();
	}

	/**
	 * FNS0420001Document parse
	 * @param xmlObjcet
	 */
	public Collection receiveBKGTB(XmlObject xmlObject) {
		
		FNS0420001Document doc = (FNS0420001Document) xmlObject;
		FNS0420001 sync = doc.getFNS0420001();
		
		EAIHeaderType header = sync.getEAIHeader();
		String instanceId = header.getInstanceId();
		String eaiEvntDt = instanceId.substring(12,26);
		
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();

		ArMstRevVvdVO model = null;
		Collection models = new ArrayList();

		for (int i = 0; row != null && i < row.length; i++) {
			
			model = new ArMstRevVvdVO();		
			model.setVslCd      (row[i].getVESSELCODE());
			model.setSkdVoyNo  	(row[i].getVOYAGENO());
			model.setSkdDirCd  	(row[i].getDIRECTIONCODE().substring(0,1));
			model.setRlaneDirCd	(row[i].getDIRECTIONCODE().substring(1));
			model.setVoyTpCd   	(row[i].getVOYAGETYPE());
			model.setSlanCd     (row[i].getVESSELSERVICELANECODE());
			model.setRlaneCd	(row[i].getREVENUELANECODE());
			model.setPortChkFlg	(row[i].getPORTCHECK());
			model.setLodQty     (row[i].getLOADABLEQUANTITY());
			model.setComVvdFlg 	(row[i].getCOMMONVVDDIVISION());
			model.setVvdComLvl 	(row[i].getCOMMONVVDCODE());
			model.setRevPortCd 	(row[i].getREVOOPORT()); //2017.02.15 백승일  잘못된 정보를 I/F 하고 있어서 수정 처리( getCALLINGPORT를 rev Port에 적용 시키고 있음)
			model.setDeltFlg    (row[i].getDELMK());
			model.setRevYrmon   ( 
					JSPUtil.getNull(StringUtils.delete(row[i].getREVOODT(),"-"))+"|"+
					JSPUtil.getNull(StringUtils.delete(row[i].getREVIMDT(),"-"))+"|"+
					JSPUtil.getNull(StringUtils.delete(row[i].getREVIEDT(),"-"))+"|"+
					JSPUtil.getNull(StringUtils.delete(row[i].getREVIADT(),"-")) 
					);
			model.setEaiEvntDt(eaiEvntDt);
			/* start 현재 row[i]로부터 가져올 수 없음. 추후 row[i]에서 가져오도록 수정하기!! 20091013 kys */
			//model.setCreUsrId(row[i].getCreUsrId());
			//model.setCreDt(row[i].getCreDt());
			model.setCreUsrId("SYSTEM");
			/* end */
			models.add( "U" );	
			models.add(model);
		}
		return models;		
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator itr = models.iterator();
		ArMstRevVvdVO model = null;

		int i=1;
		String eaiSts = "";
		while (itr.hasNext()) {
			if(i%2==1){
				eaiSts=(String)itr.next();
			}else{
				model = (ArMstRevVvdVO)itr.next();
	
				if (eaiSts.equals("C") || eaiSts.equals("U"))
					eaiSts = "U";
	
				try {
					
					String vslCd 		= model.getVslCd();
					String skdVoyNo 	= model.getSkdVoyNo();
					String skdDirCd 	= model.getSkdDirCd();
					String rlaneDirCd 	= model.getRlaneDirCd();
					
					switch (eaiSts.charAt(0)) {
					case 'U':
						if(dbDao.searchArMstRevVvdList(vslCd, skdVoyNo, skdDirCd, rlaneDirCd)){
							if ( vslCd != null && vslCd.trim().length() > 0 
									&& skdVoyNo != null && skdVoyNo.trim().length() > 0 
									&& skdDirCd != null && skdDirCd.trim().length() > 0 ) {								
								dbDao.addArMstRevVvd(model);
							}
						}else{
							if ( vslCd != null && vslCd.trim().length() > 0 
									&& skdVoyNo != null && skdVoyNo.trim().length() > 0 
									&& skdDirCd != null && skdDirCd.trim().length() > 0 ) {								
								dbDao.modifyArMstRevVvd(model);							
							}
						}
						break;
					case 'D':		
						if ( vslCd != null && vslCd.trim().length() > 0 
								&& skdVoyNo != null && skdVoyNo.trim().length() > 0 
								&& skdDirCd != null && skdDirCd.trim().length() > 0							
								&& !dbDao.searchArMstRevVvdList(vslCd, skdVoyNo, skdDirCd, rlaneDirCd)) {
							dbDao.removeArMstRevVvd(model);
						}
						break;
					}
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					throw de;
				} catch (Exception e) {
					log.error("Exception " + e.toString(), e);
				}
			}
			i++;
		}
	}
}
