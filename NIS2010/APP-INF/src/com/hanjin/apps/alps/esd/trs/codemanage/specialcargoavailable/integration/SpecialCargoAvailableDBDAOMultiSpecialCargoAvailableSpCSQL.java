/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.07 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Cargo Available S/P Insert
	  * </pre>
	  */
	public SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_mtrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovwt_tri_axl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration").append("\n"); 
		query.append("FileName : SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SPCL_CGO_AVAL_SVC_PROV(" ).append("\n"); 
		query.append("            TRSP_SPCL_CGO_SP_SEQ" ).append("\n"); 
		query.append("           ,VNDR_SEQ" ).append("\n"); 
		query.append("		   ,SO_CRE_OFC_CD" ).append("\n"); 
		query.append("           ,HZD_MTRL_FLG" ).append("\n"); 
		query.append("           ,OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("           ,CRE_OFC_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("    )VALUES( (SELECT NVL(MAX(TRSP_SPCL_CGO_SP_SEQ),0)+1 FROM TRS_SPCL_CGO_AVAL_SVC_PROV)" ).append("\n"); 
		query.append("           ,@[vndr_seq]" ).append("\n"); 
		query.append("           ,@[so_cre_ofc_cd]" ).append("\n"); 
		query.append("           ,DECODE(@[hzd_mtrl_flg],'1','Y','N')" ).append("\n"); 
		query.append("           ,DECODE(@[ovwt_tri_axl_flg],'1','Y','N')" ).append("\n"); 
		query.append("           ,@[login_ofc_cd]" ).append("\n"); 
		query.append("           ,@[login_usr_id]" ).append("\n"); 
		query.append("           ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[login_ofc_cd])" ).append("\n"); 
		query.append("           ,@[login_usr_id]" ).append("\n"); 
		query.append("           ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[login_ofc_cd])" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}