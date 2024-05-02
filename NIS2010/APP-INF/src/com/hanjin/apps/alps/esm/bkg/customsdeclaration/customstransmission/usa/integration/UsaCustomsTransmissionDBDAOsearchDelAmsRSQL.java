/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchDelAmsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchDelAmsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchDelAmsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("it_ittype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchDelAmsRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CASE WHEN @[it_ittype] in( '62', '63' ) THEN" ).append("\n"); 
		query.append("		-- 2009/09/16 Dong-il Ha, request by E-mail. mail title : 미세관 전송.." ).append("\n"); 
		query.append("		-- 메일 내용중 BR은 오기. CA가 맞음." ).append("\n"); 
		query.append("        -- 멕시코, 캐나다의 경우 대표 PORT코드로 기타항만 코드로 부여한다." ).append("\n"); 
		query.append("		NVL((SELECT NVL(NVL(C.LOC_AMS_PORT_CD, D.LOC_AMS_PORT_CD), DECODE(SUBSTR(B.DEL_CD, 1, 2), 'MX', '20195', 'CA', '13400'))" ).append("\n"); 
		query.append("			 FROM BKG_CSTMS_ADV_BL A, BKG_BOOKING B, MDM_LOCATION C, MDM_LOCATION D" ).append("\n"); 
		query.append("			 WHERE" ).append("\n"); 
		query.append("				A.CNT_CD = 'US'" ).append("\n"); 
		query.append("				AND A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("				AND B.BKG_NO    = A.BKG_NO" ).append("\n"); 
		query.append("				AND C.LOC_CD    = B.POD_CD" ).append("\n"); 
		query.append("				AND C.DELT_FLG	= 'N'" ).append("\n"); 
		query.append("				AND D.LOC_CD(+) = C.SCC_CD" ).append("\n"); 
		query.append("				AND D.DELT_FLG(+)	= 'N'" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("			), " ).append("\n"); 
		query.append("			RPAD(' ', 5, ' ')" ).append("\n"); 
		query.append("		)	" ).append("\n"); 
		query.append("	ELSE" ).append("\n"); 
		query.append("		RPAD(' ', 5, ' ')" ).append("\n"); 
		query.append("	END" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}