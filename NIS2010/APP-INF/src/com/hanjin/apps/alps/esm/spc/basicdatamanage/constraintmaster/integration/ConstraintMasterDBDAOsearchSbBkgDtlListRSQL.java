/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOsearchSbBkgDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.10.16 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOsearchSbBkgDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standby BKG의 reason정보
	  * </pre>
	  */
	public ConstraintMasterDBDAOsearchSbBkgDtlListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOsearchSbBkgDtlListRSQL").append("\n"); 
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
		query.append("SELECT S.*" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B, SPC_SB_BKG_DTL S" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("--AND NVL(B.ALOC_STS_CD, 'X') IN ('X', 'S', 'A') " ).append("\n"); 
		query.append("   AND B.BKG_STS_CD     IN ('W', 'F')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD  IN ('F', 'R')" ).append("\n"); 
		query.append("   AND NVL(S.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND S.BKG_CTRL_TP_CD    = 'S'" ).append("\n"); 

	}
}