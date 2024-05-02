/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi322ReceiveDBDAOAddEdi322MsgIFUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi322ReceiveDBDAOAddEdi322MsgIFUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddEdi322MsgIF
	  * </pre>
	  */
	public Edi322ReceiveDBDAOAddEdi322MsgIFUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BL_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_YARD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NO",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("TMNL_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PICKUP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration").append("\n"); 
		query.append("FileName : Edi322ReceiveDBDAOAddEdi322MsgIFUSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_EDI_DIR_IF D" ).append("\n"); 
		query.append("		     USING ( SELECT TO_DATE(@[EVENT_DT], 'yyyy/mm/dd HH24:MI:SS') iEVNT_DT, @[CNTR_NO] iEQ_NO,@[EVENT_STS] iEDI_STS_CD, @[EVENT_YARD] iNOD_CD," ).append("\n"); 
		query.append("		 			   @[BL_NO] iBL_EDI_322_NO, @[BKG_NO] iBKG_EDI_322_NO, @[PICKUP_NO] iPKUP_EDI_322_NO," ).append("\n"); 
		query.append("		 			    sysdate iCRE_DT,sysdate iUPD_DT, @[TMNL_ID] iCRE_USR_ID, @[TMNL_ID] iUPD_USR_ID  FROM DUAL ) S" ).append("\n"); 
		query.append("		     ON    (D.EVNT_DT = S.iEVNT_DT AND D.EQ_NO   = S.iEQ_NO AND D.EDI_STS_CD = S.iEDI_STS_CD)" ).append("\n"); 
		query.append("		    WHEN MATCHED THEN" ).append("\n"); 
		query.append("		 	UPDATE SET D.NOD_CD          = S.iNOD_CD," ).append("\n"); 
		query.append("		 		   D.BL_EDI_322_NO   = S.iBL_EDI_322_NO," ).append("\n"); 
		query.append("		 		   D.BKG_EDI_322_NO  = S.iBKG_EDI_322_NO," ).append("\n"); 
		query.append("		 		   D.PKUP_EDI_322_NO = S.iPKUP_EDI_322_NO," ).append("\n"); 
		query.append("                   D.UPD_USR_ID      = S.iUPD_USR_ID," ).append("\n"); 
		query.append("		 		   D.UPD_DT          = S.iUPD_DT" ).append("\n"); 
		query.append("		    WHEN NOT MATCHED THEN INSERT (D.EVNT_DT, D.EQ_NO, D.EDI_STS_CD, D.NOD_CD," ).append("\n"); 
		query.append("		 				    D.BL_EDI_322_NO, D.BKG_EDI_322_NO, D.PKUP_EDI_322_NO" ).append("\n"); 
		query.append("                            ,D.CRE_USR_ID,D.UPD_USR_ID,D.UPD_DT" ).append("\n"); 
		query.append("                            , D.CRE_DT)" ).append("\n"); 
		query.append("		 	VALUES  (S.iEVNT_DT, S.iEQ_NO, S.iEDI_STS_CD, S.iNOD_CD," ).append("\n"); 
		query.append("		 		 S.iBL_EDI_322_NO, S.iBKG_EDI_322_NO, S.iPKUP_EDI_322_NO" ).append("\n"); 
		query.append("                 ,S.iCRE_USR_ID,S.iUPD_USR_ID,S.iUPD_DT" ).append("\n"); 
		query.append("                 , S.iCRE_DT)" ).append("\n"); 

	}
}