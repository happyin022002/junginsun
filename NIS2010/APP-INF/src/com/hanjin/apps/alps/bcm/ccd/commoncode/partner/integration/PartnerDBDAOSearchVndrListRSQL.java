/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOSearchVndrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchVndrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 테이블의 목록을 조회한다
	  * </pre>
	  */
	public PartnerDBDAOSearchVndrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchVndrListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (SELECT ROWNUM AS NO" ).append("\n"); 
		query.append("	 		 , B.*  " ).append("\n"); 
		query.append("  		  FROM (SELECT LPAD(A.VNDR_SEQ, 6, '0') AS VNDR_SEQ" ).append("\n"); 
		query.append("		 	 		 , A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		 	 		 , A.ENG_ADDR" ).append("\n"); 
		query.append("			 		 , A.LOC_CD" ).append("\n"); 
		query.append("		 	 		 , A.OFC_CD" ).append("\n"); 
		query.append("			 		 , A.RGST_NO" ).append("\n"); 
		query.append("          		  FROM MDM_VENDOR A" ).append("\n"); 
		query.append("     	 		 WHERE 1=1" ).append("\n"); 
		query.append("#if (${vndr_cnt_cd} != '')" ).append("\n"); 
		query.append("	   	   		   AND A.VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	   	   		   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("  		   		   AND A.LOC_CD LIKE @[loc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   		   		   AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgst_no} != '')" ).append("\n"); 
		query.append("   		   		   AND A.RGST_NO LIKE '%' || @[rgst_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("   		   		   AND A.VNDR_LGL_ENG_NM LIKE '%' || @[vndr_lgl_eng_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eng_addr} != '')" ).append("\n"); 
		query.append("   		   		   AND A.ENG_ADDR LIKE '%' || @[eng_addr] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         		 ORDER BY A.VNDR_SEQ) B)" ).append("\n"); 
		query.append(" WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}