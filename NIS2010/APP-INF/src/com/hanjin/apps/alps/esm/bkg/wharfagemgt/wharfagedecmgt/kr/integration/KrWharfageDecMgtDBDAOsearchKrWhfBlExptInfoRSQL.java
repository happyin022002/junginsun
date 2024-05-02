/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.11 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.ATTR_CTNT1 AS KR_WHF_EXPT_CD," ).append("\n"); 
		query.append("A.ATTR_CTNT5 AS KR_WHF_EXPT_DESC," ).append("\n"); 
		query.append("DECODE(A.ATTR_CTNT1, B.BKG_RT_WHF_EXPT_CD, 'Y', 'N') AS KR_WHF_EXPT_APPL_FLG," ).append("\n"); 
		query.append("B.WHF_SHPR_RGST_NO" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT A, NISADM.BKG_RATE B" ).append("\n"); 
		query.append("WHERE A.HRD_CDG_ID = 'KR_WHF_EXEMPT_CD'" ).append("\n"); 
		query.append("AND B.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_RT_WHF_EXPT_CD(+) = A.ATTR_CTNT1" ).append("\n"); 
		query.append("ORDER BY ATTR_CTNT6" ).append("\n"); 

	}
}