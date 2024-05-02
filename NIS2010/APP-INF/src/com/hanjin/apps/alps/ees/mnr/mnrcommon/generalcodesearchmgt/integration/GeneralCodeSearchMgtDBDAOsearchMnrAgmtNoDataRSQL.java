/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrAgmtNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement No 정보를 조회한다.
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrAgmtNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtNoDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT AGMT_OFC_CTY_CD||LTRIM(TO_CHAR(AGMT_SEQ, '000000')) AGMT_NO" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CTY_CD  = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("AND   AGMT_SEQ         = TO_NUMBER(SUBSTR(@[agmt_no], 4))" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   AGMT_OFC_CD      = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   DELT_FLG         = 'N'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}