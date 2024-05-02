/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchMtyROBVVDDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11 
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

public class CntrMtyBkgCreateDBDAOSearchMtyROBVVDDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB Booking 의 VVD 상세 정보
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchMtyROBVVDDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchMtyROBVVDDetailRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.VSL_PRE_PST_CD, 'T', 'Trunk', 'Post') VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,A.POL_YD_CD" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("            SELECT TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("            WHERE   X.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("            AND   X.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   X.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   X.VPS_PORT_CD  = A.POL_CD" ).append("\n"); 
		query.append("            AND   X.CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ          " ).append("\n"); 
		query.append("       ) ETD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,A.POD_YD_CD" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("            SELECT TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("            WHERE   X.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("            AND   X.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   X.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   X.VPS_PORT_CD  = A.POD_CD" ).append("\n"); 
		query.append("            AND   X.CLPT_IND_SEQ = A.POD_CLPT_IND_SEQ           " ).append("\n"); 
		query.append("       ) ETB" ).append("\n"); 
		query.append("      ,A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM BKG_VVD A" ).append("\n"); 
		query.append("WHERE A.BKG_NO     = @[bkg_no] --BKG_NO" ).append("\n"); 
		query.append("ORDER BY A.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("        ,A.VSL_SEQ" ).append("\n"); 

	}
}