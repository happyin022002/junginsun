/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfNoExptCustRgstNoDistinctKntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.04 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfNoExptCustRgstNoDistinctKntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfNoExptCustRgstNoDistinctKntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfNoExptCustRgstNoDistinctKntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS DISTINCT_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT TRIM(NVL(CUST_RGST_NO,' '))" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND DECODE(substr(@[whf_bnd_cd],1,1),'O',WHF_POL_CD,WHF_POD_CD)  = @[port_cd]" ).append("\n"); 
		query.append("#if(${whf_bnd_cd} !='ON')" ).append("\n"); 
		query.append("AND WHF_BND_CD  = @[whf_bnd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND WHF_BND_CD  IN ( DECODE(@[whf_bnd_cd],'ON','OO',@[whf_bnd_cd]) , DECODE(@[whf_bnd_cd],'ON','OT',@[whf_bnd_cd]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}