/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitCntrInfoRSQL.java
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

public class CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG 에 넘겨줄 SPLIT BKG NO - CNTR NO, CNTR TPSZ, MVMT 정보 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitCntrInfoRSQL(){
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
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT INP_MSG2 CNTR_NO  " ).append("\n"); 
		query.append("      ,INP_MSG3 CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("      ,INP_MSG9 MVMT_STS_CD   " ).append("\n"); 
		query.append("FROM EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   INP_MSG1= @[vl_bkg_no] " ).append("\n"); 

	}
}