/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOsearchPreNextVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOsearchPreNextVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2ND VVD 정보 조회를 위해 T/S일 경우 PRE/NEXT 정보를 구한다. POD(INBOUND) T/S 경우 NEXT, POL(OUTBOUND) T/S 경우 PRE정보
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOsearchPreNextVslInfoRSQL(){
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
		params.put("input_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOsearchPreNextVslInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_GET_TOKEN_FNC(PREV_VVD,1) AS PRE_VVD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(PREV_VVD,2) AS PRE_POL_CD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(PREV_VVD,3) AS PRE_POD_CD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(NEXT_VVD,1) AS NEXT_VVD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(NEXT_VVD,2) AS NEXT_POL_CD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(NEXT_VVD,3) AS NEXT_POD_CD" ).append("\n"); 
		query.append("  FROM ( SELECT LAG(VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||POD_CD, 1)  OVER (ORDER BY VSL_PRE_PST_CD,VSL_SEQ) PREV_VVD" ).append("\n"); 
		query.append("              , LEAD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||POD_CD, 1) OVER (ORDER BY VSL_PRE_PST_CD,VSL_SEQ) NEXT_VVD" ).append("\n"); 
		query.append("              , VVD.*" ).append("\n"); 
		query.append("           FROM BKG_VVD VVD" ).append("\n"); 
		query.append("          WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("       ) X " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("  #if (${e_i_ind} == 'E')" ).append("\n"); 
		query.append("	  AND POL_CD = @[input_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("	  AND POd_CD = @[input_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  AND ROWNUM = 1 " ).append("\n"); 

	}
}