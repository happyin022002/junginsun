/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ds_po_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CGO_RLSE (" ).append("\n"); 
		query.append("            BL_NO                   ," ).append("\n"); 
		query.append("            HBL_FLG                 ," ).append("\n"); 
		query.append("            FRT_CLT_FLG             ," ).append("\n"); 
		query.append("            FRT_CLT_LST_DT          ," ).append("\n"); 
		query.append("            OBL_RDEM_FLG            ," ).append("\n"); 
		query.append("            OBL_RDEM_LST_DT         ," ).append("\n"); 
		query.append("            CSTMS_CLR_CD            ," ).append("\n"); 
		query.append("            CSTMS_CLR_LST_DT        ," ).append("\n"); 
		query.append("            CSTMS_DSPO_CD           ," ).append("\n"); 
		query.append("            MRN_TML_EDI_SND_FLG     ," ).append("\n"); 
		query.append("            MRN_TML_EDI_SND_CD      ," ).append("\n"); 
		query.append("            MRN_TML_EDI_LST_SND_DT  ," ).append("\n"); 
		query.append("            MRN_TML_EDI_LST_SND_GDT ," ).append("\n"); 
		query.append("            MRN_TML_EDI_RCV_ID      ," ).append("\n"); 
		query.append("            MRN_TML_EDI_LST_MSG_ID  ," ).append("\n"); 
		query.append("            MRN_TML_EDI_LST_SCS_FLG ," ).append("\n"); 
		query.append("            INLND_YD_EDI_SND_FLG    ," ).append("\n"); 
		query.append("            INLND_YD_EDI_SND_CD     ," ).append("\n"); 
		query.append("            INLND_YD_EDI_LST_SND_DT ," ).append("\n"); 
		query.append("            INLND_YD_EDI_LST_SND_GDT," ).append("\n"); 
		query.append("            INLND_YD_EDI_RCV_ID     ," ).append("\n"); 
		query.append("            INLND_YD_EDI_LST_MSG_ID ," ).append("\n"); 
		query.append("            INLND_YD_EDI_LST_SCS_FLG," ).append("\n"); 
		query.append("            CRE_USR_ID              ," ).append("\n"); 
		query.append("            CRE_DT                  ," ).append("\n"); 
		query.append("            UPD_USR_ID              ," ).append("\n"); 
		query.append("            UPD_DT                  )" ).append("\n"); 
		query.append("    VALUES (@[bl_no],  /* 변수 치환 blNo */" ).append("\n"); 
		query.append("            'N'           ," ).append("\n"); 
		query.append("            'N'           ,  " ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ,  " ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            @[cstms_clr_cd]           , /* 변수 치환 cstmsClrCd */" ).append("\n"); 
		query.append("            GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC')," ).append("\n"); 
		query.append("            @[cstms_ds_po_cd]          , /* 변수 치환 cstmsDspoCd */" ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            @[evnt_usr_id]         , /* 변수 치환 evntUsrId */" ).append("\n"); 
		query.append("            SYSDATE       ," ).append("\n"); 
		query.append("            @[evnt_usr_id]         , /* 변수 치환 blNo */" ).append("\n"); 
		query.append("            SYSDATE       )" ).append("\n"); 

	}
}