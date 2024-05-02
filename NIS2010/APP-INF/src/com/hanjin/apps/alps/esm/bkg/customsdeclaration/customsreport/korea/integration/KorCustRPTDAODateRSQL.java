/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustRPTDAODateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.21 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class KorCustRPTDAODateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 날짜값으로 다운로드 히스토리를 셀렉트한다.
	  * </pre>
	  */
	public KorCustRPTDAODateRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "1,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "1,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT MRN_NO||MRN_CHK_NO			   AS MRN" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD  AS VVD" ).append("\n"); 
		query.append(", NVL(POL_CD, ' ')				   AS POL" ).append("\n"); 
		query.append(", NVL(POD_CD, ' ')				   AS POD" ).append("\n"); 
		query.append(", NVL(OFC_CD, ' ')				   AS OFFICE" ).append("\n"); 
		query.append(", NVL(CRE_USR_ID, ' ')			   AS USERID" ).append("\n"); 
		query.append(", NVL(BL_KNT, 0)				   AS BLCOUNT" ).append("\n"); 
		query.append(", NVL(KR_CSTMS_DL_ACT_CD, ' ')	   AS AC" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYYMMDD')	   AS DT" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'HH24:MI:SS')   AS DT2" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_DL_HIS" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${date_from} != '')" ).append("\n"); 
		query.append("#if(${date_to} != '')" ).append("\n"); 
		query.append("AND CRE_DT BETWEEN TO_DATE(@[date_from],'YYYYMMDD') AND TO_DATE(@[date_to],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CRE_DT >= TO_DATE(@[date_from],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${date_to} != '')" ).append("\n"); 
		query.append("AND CRE_DT <= TO_DATE(@[date_to], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CRE_DT" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KorCustRPTDAODateRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}