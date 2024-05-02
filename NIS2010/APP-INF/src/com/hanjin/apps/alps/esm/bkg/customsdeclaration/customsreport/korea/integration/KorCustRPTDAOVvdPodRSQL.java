/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustRPTDAOVvdPodRSQL.java
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

public class KorCustRPTDAOVvdPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD, POD로 조회
	  * </pre>
	  */
	public KorCustRPTDAOVvdPodRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "1,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txt_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "1,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txt_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("#if (${txt_vvd} != '')" ).append("\n"); 
		query.append("WHERE VSL_CD 		= SUBSTR(@[txt_vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO 	= SUBSTR(@[txt_vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD 	= SUBSTR(@[txt_vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${txt_pod} != '')" ).append("\n"); 
		query.append("AND POD_CD = @[txt_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MRN_NO||MRN_CHK_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KorCustRPTDAOVvdPodRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}