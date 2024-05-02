/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlExpInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlExpInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKrWhfBlExpInfo
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlExpInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlExpInfoRSQL").append("\n"); 
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
		query.append("SELECT	MAX(DECODE(B.BKG_CUST_TP_CD, 'S', B.CUST_NM, '')) AS SHIPPER_NAME," ).append("\n"); 
		query.append("		MAX(DECODE(B.BKG_CUST_TP_CD, 'E', B.CUST_NM, '')) AS EXPORT_REF, " ).append("\n"); 
		query.append("		C.CSTMS_DESC," ).append("\n"); 
		query.append("		A.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		D.BKG_RT_WHF_EXPT_CD," ).append("\n"); 
		query.append("		D.WHF_SHPR_RGST_NO," ).append("\n"); 
		query.append("		C.BDR_FLG BDR," ).append("\n"); 
		query.append("		MAX(DECODE(SUBSTR(E.CORR_NO,1,3),'TMP','Y','N')) CA" ).append("\n"); 
		query.append("FROM	BKG_BOOKING	 A," ).append("\n"); 
		query.append("		BKG_CUSTOMER B," ).append("\n"); 
		query.append("		BKG_BL_DOC C," ).append("\n"); 
		query.append("		BKG_RATE D," ).append("\n"); 
		query.append("		BKG_CORRECTION E" ).append("\n"); 
		query.append("WHERE	1=1	" ).append("\n"); 
		query.append("AND     A.BKG_NO    			=	@[bkg_no]" ).append("\n"); 
		query.append("AND		A.BKG_NO				=	B.BKG_NO" ).append("\n"); 
		query.append("AND		A.BKG_NO				=	C.BKG_NO(+)" ).append("\n"); 
		query.append("AND		A.BKG_NO				=	D.BKG_NO(+)" ).append("\n"); 
		query.append("AND		A.BKG_NO				=	E.BKG_NO(+)" ).append("\n"); 
		query.append("AND		B.BKG_CUST_TP_CD				IN	('S', 'E')" ).append("\n"); 
		query.append("GROUP BY	A.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("			C.CSTMS_DESC," ).append("\n"); 
		query.append("			D.BKG_RT_WHF_EXPT_CD," ).append("\n"); 
		query.append("			D.WHF_SHPR_RGST_NO," ).append("\n"); 
		query.append("			C.BDR_FLG" ).append("\n"); 

	}
}