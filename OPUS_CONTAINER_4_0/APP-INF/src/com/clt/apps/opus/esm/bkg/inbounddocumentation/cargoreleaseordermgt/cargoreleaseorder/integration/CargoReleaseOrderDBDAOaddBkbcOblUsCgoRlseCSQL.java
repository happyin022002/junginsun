/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseCSQL.java
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

public class CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseCSQL(){
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
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseCSQL").append("\n"); 
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
		query.append("    VALUES (@[bl_no]," ).append("\n"); 
		query.append("            'N'           ," ).append("\n"); 
		query.append("            'N'           ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            DECODE(@[cgor_team_cd],'S',@[obl_rdem_flg],'N')," ).append("\n"); 
		query.append("            GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC')," ).append("\n"); 
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
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            NULL          ," ).append("\n"); 
		query.append("            @[evnt_usr_id], " ).append("\n"); 
		query.append("            SYSDATE       ," ).append("\n"); 
		query.append("            @[evnt_usr_id], " ).append("\n"); 
		query.append("            SYSDATE       )" ).append("\n"); 

	}
}