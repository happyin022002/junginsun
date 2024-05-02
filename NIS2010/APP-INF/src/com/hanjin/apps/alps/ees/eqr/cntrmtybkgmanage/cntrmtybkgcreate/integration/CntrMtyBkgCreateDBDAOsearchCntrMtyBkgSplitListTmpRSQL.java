/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgSplitListTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 
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

public class CntrMtyBkgCreateDBDAOsearchCntrMtyBkgSplitListTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_DAT_VRFY 에 입력된 ORG BKG NO 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOsearchCntrMtyBkgSplitListTmpRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgSplitListTmpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT INP_MSG1 VL_BKG_NO  " ).append("\n"); 
		query.append("      ,INP_MSG7          POD_YD_CD  " ).append("\n"); 
		query.append("      ,INP_MSG8          TO_ETB_DT" ).append("\n"); 
		query.append("      ,INP_MSG10         VSL_CD     -- vsl_cd" ).append("\n"); 
		query.append("      ,INP_MSG11         SKD_VOY_NO -- skd_voy_no" ).append("\n"); 
		query.append("      ,INP_MSG12         SKD_DIR_CD -- skd_dir_cd" ).append("\n"); 
		query.append("FROM EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 

	}
}