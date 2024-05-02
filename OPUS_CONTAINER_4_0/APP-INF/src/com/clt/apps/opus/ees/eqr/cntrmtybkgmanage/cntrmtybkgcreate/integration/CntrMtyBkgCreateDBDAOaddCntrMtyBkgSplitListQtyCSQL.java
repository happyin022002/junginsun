/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("old_bkg_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
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
		query.append("INSERT INTO EQR_VSL_EXE_PLN_QTY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	   REPO_PLN_ID" ).append("\n"); 
		query.append("	,  PLN_YRWK" ).append("\n"); 
		query.append("	,  PLN_SEQ " ).append("\n"); 
		query.append("	,  REF_ID" ).append("\n"); 
		query.append("	,  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,  CNTR_QTY" ).append("\n"); 
		query.append("	,  LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append("	,  PLN_UC_AMT" ).append("\n"); 
		query.append("	,  LODG_PORT_UC_AMT" ).append("\n"); 
		query.append("	,  DCHG_PORT_UC_AMT" ).append("\n"); 
		query.append("	,  CRE_USR_ID" ).append("\n"); 
		query.append("	,  CRE_DT" ).append("\n"); 
		query.append("	,  UPD_USR_ID" ).append("\n"); 
		query.append("	,  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  REPO_PLN_ID" ).append("\n"); 
		query.append("      , PLN_YRWK" ).append("\n"); 
		query.append("      , PLN_SEQ" ).append("\n"); 
		query.append("      , @[ref_id]" ).append("\n"); 
		query.append("      , @[cntr_tp_sz]" ).append("\n"); 
		query.append("      , @[cntr_qty]" ).append("\n"); 
		query.append("      , 0 AS LODG_DCHG_COST_AMT " ).append("\n"); 
		query.append("      , 0 AS PLN_UC_AMT " ).append("\n"); 
		query.append("      , 0 AS LODG_PORT_UC_AMT " ).append("\n"); 
		query.append("      , 0 AS DCHG_PORT_UC_AMT " ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("  FROM EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND MTY_BKG_NO = @[old_bkg_grp_no]" ).append("\n"); 

	}
}