/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddUsCgoRlseHisByMultiEdiCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddUsCgoRlseHisByMultiEdiCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Complete IVC 버튼에 해당하는 Multi BL 315 전송시에 history를 IVC로 쌓음
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddUsCgoRlseHisByMultiEdiCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddUsCgoRlseHisByMultiEdiCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("(BL_NO				,   " ).append("\n"); 
		query.append(" HIS_SEQ		    ,   " ).append("\n"); 
		query.append(" FRT_CLT_FLG		,   " ).append("\n"); 
		query.append(" OBL_RDEM_FLG	    ,   " ).append("\n"); 
		query.append(" CSTMS_CLR_CD	    ,   " ).append("\n"); 
		query.append(" CSTMS_DSPO_CD	    ,   " ).append("\n"); 
		query.append(" CUST_EDI_SND_CD    ,   " ).append("\n"); 
		query.append(" MRN_TML_EDI_SND_CD	,   " ).append("\n"); 
		query.append(" INLND_YD_EDI_SND_CD,   " ).append("\n"); 
		query.append(" EVNT_OFC_CD	    ,   " ).append("\n"); 
		query.append(" CGOR_EVNT_TP_CD	,   " ).append("\n"); 
		query.append(" EVNT_USR_ID	    ,   " ).append("\n"); 
		query.append(" EVNT_DT	        ,   " ).append("\n"); 
		query.append(" CGOR_TEAM_CD       ,   " ).append("\n"); 
		query.append(" CGOR_EVNT_NM       ,   " ).append("\n"); 
		query.append(" EVNT_GDT           ,   " ).append("\n"); 
		query.append(" CRE_USR_ID	        ,   " ).append("\n"); 
		query.append(" CRE_DT			    ,   " ).append("\n"); 
		query.append(" UPD_USR_ID			,   " ).append("\n"); 
		query.append(" UPD_DT				,   " ).append("\n"); 
		query.append(" CSTMS_LOC_CD)           " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT @[bl_no]     ,   " ).append("\n"); 
		query.append("       (SELECT NVL(MAX(HIS_SEQ),0) + 1 FROM BKG_CGO_RLSE_HIS WHERE BL_NO = @[bl_no]) ,  " ).append("\n"); 
		query.append("       FRT_CLT_FLG    ,   " ).append("\n"); 
		query.append("       OBL_RDEM_FLG    ,   " ).append("\n"); 
		query.append("       CSTMS_CLR_CD   ,   " ).append("\n"); 
		query.append("       CSTMS_DSPO_CD,         " ).append("\n"); 
		query.append("       NULL               ,   " ).append("\n"); 
		query.append("       NULL               ,   " ).append("\n"); 
		query.append("       NULL               ,   " ).append("\n"); 
		query.append("       @[ofc_cd]           ,   " ).append("\n"); 
		query.append("       NULL               ,   " ).append("\n"); 
		query.append("       @[usr_id]              ,   " ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC')," ).append("\n"); 
		query.append("       'M'                ,   " ).append("\n"); 
		query.append("       'IVC'           ,   " ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'GMT')," ).append("\n"); 
		query.append("       @[usr_id]              ," ).append("\n"); 
		query.append("       SYSDATE            ," ).append("\n"); 
		query.append("       @[usr_id]              ," ).append("\n"); 
		query.append("       SYSDATE            ," ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         SELECT MAX(CSTMS_LOC_CD)" ).append("\n"); 
		query.append("         FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("         AND HIS_SEQ = (SELECT MAX(HIS_SEQ)   " ).append("\n"); 
		query.append("                        FROM BKG_CGO_RLSE_HIS " ).append("\n"); 
		query.append("                        WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE" ).append("\n"); 
		query.append(" WHERE BL_NO   = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}