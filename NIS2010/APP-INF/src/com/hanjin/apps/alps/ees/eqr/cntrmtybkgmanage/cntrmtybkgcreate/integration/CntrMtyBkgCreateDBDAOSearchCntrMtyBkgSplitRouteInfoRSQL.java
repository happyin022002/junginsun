/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.09 
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
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
		query.append("      ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("      ,A.POL_YD_CD  FM_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.POL_ETD_DT, 'YYYY-MM-DD HH24MISS') FM_ETD_DT " ).append("\n"); 
		query.append("      ,A.POL_CLPT_IND_SEQ     " ).append("\n"); 
		query.append("      ,B.TO_YD_CD   TO_YD_CD" ).append("\n"); 
		query.append("      ,B.TO_ETB_DT  TO_ETB_DT" ).append("\n"); 
		query.append("      ,B.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A.MTY_BKG_NO  " ).append("\n"); 
		query.append("      ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("FROM EQR_CTRL_MTY_BKG_EXE A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT INP_MSG1  BKG_NO" ).append("\n"); 
		query.append("              ,INP_MSG7  TO_YD_CD" ).append("\n"); 
		query.append("              ,INP_MSG8  TO_ETB_DT " ).append("\n"); 
		query.append("              ,INP_MSG13 POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("        WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("        AND   INP_MSG1= @[vl_bkg_no]" ).append("\n"); 
		query.append("        AND   ROWNUM=1" ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("WHERE A.MTY_BKG_NO = B.BKG_NO -- VL BKG NO" ).append("\n"); 
		query.append("AND   A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   A.MTY_BKG_NO = @[vl_bkg_no]" ).append("\n"); 

	}
}