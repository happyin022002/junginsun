/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchRemvInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.01 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchRemvInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRemvInfo
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchRemvInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rnum",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchRemvInfoRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT RS.DSPO_CD AS HLD_CD" ).append("\n"); 
		query.append("		      ,TO_CHAR(RS.ARR_DT, 'YYYY-MM-DD HH24:MI:SS') AS HLD_DT" ).append("\n"); 
		query.append("		      ,ROW_NUMBER() OVER(ORDER BY ARR_DT) AS RNUM" ).append("\n"); 
		query.append("		      ,COUNT(*) OVER() AS CNT" ).append("\n"); 
		query.append("		  FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("		 WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		   AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		   AND @[remv_cd] LIKE '%' || RS.DSPO_CD || '%'" ).append("\n"); 
		query.append("		) TB" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${last} == 'LAST') " ).append("\n"); 
		query.append("   AND TB.CNT = TB.RNUM" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND (CASE WHEN TB.CNT >= @[rnum] THEN TO_CHAR(TB.RNUM)" ).append("\n"); 
		query.append("        ELSE @[rnum]" ).append("\n"); 
		query.append("        END) = @[rnum]" ).append("\n"); 
		query.append("   AND (CASE WHEN TB.CNT >= @[rnum] THEN TB.CNT" ).append("\n"); 
		query.append("        ELSE TB.RNUM" ).append("\n"); 
		query.append("        END) = TB.CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}