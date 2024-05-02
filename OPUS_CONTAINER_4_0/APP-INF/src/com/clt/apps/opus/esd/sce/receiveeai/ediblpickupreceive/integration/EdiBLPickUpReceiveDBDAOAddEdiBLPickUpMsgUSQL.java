/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2014.11.04 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**OK
	  * <pre>
	  * AddEdiBLPickUpMsg
	  * </pre>
	  */
	public EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NBR",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PICK_NBR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SYS_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BL_NBR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_STS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("YARD_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration").append("\n"); 
		query.append("FileName : EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("MERGE INTO EDI_322_MSG D	                                 " ).append("\n"); 
		query.append("		     USING ( SELECT TO_DATE(@[SYS_DT], 'yyyy/mm/dd HH24:MI:SS') iEVNT_DT, @[CNTR_NBR] iEQ_NO,@[EVENT_STS]  iEDI_322_STS_CD, " ).append("\n"); 
		query.append("		 		             @[YARD_CD] iEVNT_YD_CD, @[BL_NBR] iBL_EDI_322_NO," ).append("\n"); 
		query.append("		 		             sysdate iCRE_DT,sysdate iUPD_DT, @[PICK_NBR] iPKUP_EDI_322_NO FROM DUAL ) S " ).append("\n"); 
		query.append("		     ON  (D.EVNT_DT = S.iEVNT_DT AND D.EQ_NO   = S.iEQ_NO AND D.EDI_322_STS_CD = S.iEDI_322_STS_CD) " ).append("\n"); 
		query.append("		    WHEN MATCHED THEN  " ).append("\n"); 
		query.append("		         UPDATE SET D.EVNT_YD_CD	      = S.iEVNT_YD_CD," ).append("\n"); 
		query.append("		                    D.BL_EDI_322_NO	  = S.iBL_EDI_322_NO," ).append("\n"); 
		query.append("		                    D.UPD_DT		      = S.iUPD_DT,          " ).append("\n"); 
		query.append("		                    D.PKUP_EDI_322_NO    = S.iPKUP_EDI_322_NO  " ).append("\n"); 
		query.append("		    WHEN NOT MATCHED THEN INSERT (D.EVNT_DT, D.EQ_NO, D.EDI_322_STS_CD,                 " ).append("\n"); 
		query.append("		                                  D.EVNT_YD_CD,D.BL_EDI_322_NO,    " ).append("\n"); 
		query.append("		                                  D.CRE_DT, D.PKUP_EDI_322_NO,                " ).append("\n"); 
		query.append("		                                  D.UPD_DT)                              " ).append("\n"); 
		query.append("		         VALUES  (S.iEVNT_DT, S.iEQ_NO, S.iEDI_322_STS_CD,                              " ).append("\n"); 
		query.append("		                  S.iEVNT_YD_CD,S.iBL_EDI_322_NO,                " ).append("\n"); 
		query.append("		                  S.iCRE_DT, S.iPKUP_EDI_322_NO,                              " ).append("\n"); 
		query.append("		                  S.iUPD_DT)" ).append("\n"); 

	}
}