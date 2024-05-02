/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchHoldInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.01 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchHoldInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHoldInfo
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchHoldInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchHoldInfoRSQL").append("\n"); 
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
		query.append("SELECT TB2.*" ).append("\n"); 
		query.append("      ,DECODE(RNUM, MAX(RNUM) OVER(PARTITION BY HLD_CD), 'LAST', '') AS LAST" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER(PARTITION BY TB.HLD_CD ORDER BY HLD_DT) RNUM" ).append("\n"); 
		query.append("      ,CD.ATTR_CTNT4 AS REMV_CD" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT RS.DSPO_CD AS HLD_CD" ).append("\n"); 
		query.append("		      ,TO_CHAR(RS.ARR_DT, 'YYYY-MM-DD HH24:MI:SS') AS HLD_DT" ).append("\n"); 
		query.append("		  FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("		      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("		 WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		   AND RS.CNT_CD = CD.CNT_CD" ).append("\n"); 
		query.append("		   AND RS.DSPO_CD = CD.ATTR_CTNT3" ).append("\n"); 
		query.append("		   AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		   AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("		   AND CD.CSTMS_DIV_ID IN('CARGO_RLS_H_CD')" ).append("\n"); 
		query.append("		MINUS" ).append("\n"); 
		query.append("		SELECT CSTMS_PRE_HLD_CD" ).append("\n"); 
		query.append("		      ,TO_CHAR(NTC.PRE_HLD_DT, 'YYYY-MM-DD HH24:MI:SS') AS ARR_DT" ).append("\n"); 
		query.append("		  FROM BKG_HLD_NTC NTC" ).append("\n"); 
		query.append("		      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("		 WHERE NTC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		   AND NTC.HLD_NTC_TP_CD = 'CF'" ).append("\n"); 
		query.append("		) TB" ).append("\n"); 
		query.append("		,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append(" WHERE CD.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND CD.CSTMS_DIV_ID = 'CARGO_RLS_H_CD'" ).append("\n"); 
		query.append("   AND CD.ATTR_CTNT3 = TB.HLD_CD" ).append("\n"); 
		query.append("  )TB2" ).append("\n"); 
		query.append("ORDER BY HLD_DT" ).append("\n"); 

	}
}