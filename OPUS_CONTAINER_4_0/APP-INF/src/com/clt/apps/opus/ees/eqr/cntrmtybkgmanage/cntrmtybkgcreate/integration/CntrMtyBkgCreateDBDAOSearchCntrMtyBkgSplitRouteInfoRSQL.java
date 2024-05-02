/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL.java
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

public class CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG/DOC 에 제공할 BKG VD ROUTE 정보 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,'' AS BKG_EXE_SEQ --BKG_EXE_SEQ" ).append("\n"); 
		query.append("      ,A.FM_YD_CD AS FM_YD_CD " ).append("\n"); 
		query.append("      ,TO_CHAR(A.FM_ETD_DT, 'YYYY-MM-DD HH24MISS') AS FM_ETD_DT " ).append("\n"); 
		query.append("      ,'' AS POL_CLPT_IND_SEQ --A.POL_CLPT_IND_SEQ     " ).append("\n"); 
		query.append("      ,B.TO_YD_CD   TO_YD_CD" ).append("\n"); 
		query.append("      ,B.TO_ETB_DT  TO_ETB_DT" ).append("\n"); 
		query.append("      ,B.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A.MTY_BKG_NO  " ).append("\n"); 
		query.append("      ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("      ,B.CNTR_TP_SZ AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,B.CNTR_QTY" ).append("\n"); 
		query.append("FROM EQR_VSL_LODG_DCHG_EXE_PLN A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT INP_MSG1  BKG_NO" ).append("\n"); 
		query.append("              ,INP_MSG7  TO_YD_CD" ).append("\n"); 
		query.append("              ,INP_MSG8  TO_ETB_DT " ).append("\n"); 
		query.append("              ,INP_MSG13 POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              ,INP_MSG3  CNTR_TP_SZ" ).append("\n"); 
		query.append("  			  ,COUNT(INP_MSG6) CNTR_QTY" ).append("\n"); 
		query.append("        FROM EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("        WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("        AND   INP_MSG1= @[vl_bkg_no]" ).append("\n"); 
		query.append("        GROUP BY INP_MSG1, INP_MSG7, INP_MSG8, INP_MSG13, INP_MSG3" ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("WHERE A.MTY_BKG_NO = B.BKG_NO -- VL BKG NO" ).append("\n"); 
		query.append("AND   A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   A.MTY_BKG_NO = @[vl_bkg_no]" ).append("\n"); 

	}
}