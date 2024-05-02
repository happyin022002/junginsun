/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_MTY_BKG_EXE_QTY 실행테이블에 QTY=0으로 입력
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_exe_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_MTY_BKG_EXE_QTY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    TRSP_MOD_CD" ).append("\n"); 
		query.append("   ,VSL_CD" ).append("\n"); 
		query.append("   ,SKD_VOY_NO" ).append("\n"); 
		query.append("   ,SKD_DIR_CD" ).append("\n"); 
		query.append("   ,BKG_EXE_SEQ" ).append("\n"); 
		query.append("   ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ,CNTR_QTY" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[trsp_mod_cd] TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,@[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("      ,@[skd_voy_no]  SKD_VOY_NO" ).append("\n"); 
		query.append("      ,@[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("      ,@[bkg_exe_seq] BKG_EXE_SEQ" ).append("\n"); 
		query.append("      ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,0 CNTR_QTY" ).append("\n"); 
		query.append("      ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("FROM DUAL A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT INTG_CD_VAL_CTNT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD00830'  -- EQR TYPE SIZE ALL " ).append("\n"); 
		query.append("     ) B" ).append("\n"); 

	}
}