/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOCheckInvCalcCostCDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2011.03.10 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkChaeHeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOCheckInvCalcCostCDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckInvCalcCostCD
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOCheckInvCalcCostCDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOCheckInvCalcCostCDRSQL").append("\n"); 
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
		query.append("	 H.INV_NO, D.TML_CRR_CD, D.LGS_COST_CD," ).append("\n"); 
		query.append("	 CASE" ).append("\n"); 
		query.append("	 WHEN (SELECT SUM(NVL(DECODE(D2.CALC_TP_CD,'A',1,0),0)) FROM TES_TML_SO_DTL D2" ).append("\n"); 
		query.append("		   WHERE D2.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND D2.TML_SO_SEQ = D.TML_SO_SEQ) > 0 THEN 'Y'  --하나라도 'AUTO'인 경우 무조건 통과" ).append("\n"); 
		query.append("--		소급 적용 처리 기능 추가 ( 2009-06-17 이경한 과장)" ).append("\n"); 
		query.append("	 WHEN NVL(H.RTRO_TML_INV_FLG, 'N' ) = 'Y' THEN 'Y' 		  --소급 적용 처리 값이 'Y'인 경우 통과" ).append("\n"); 
		query.append("	 WHEN SUM(NVL(DECODE(D.CALC_TP_CD,'M',0,1),0)) = 0 THEN      --전부 'MANUAL'인 경우 TES_TML_SO_COST.CNTR_STY_CD가 전부 'M'일 경우 통과" ).append("\n"); 
		query.append("		CASE" ).append("\n"); 
		query.append("		WHEN (SELECT C.CNTR_STY_CD FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = D.LGS_COST_CD) <> 'M' THEN" ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("			WHEN (SELECT C.COST_CALC_MZD_CD FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = D.LGS_COST_CD) = 'A' THEN" ).append("\n"); 
		query.append("				DECODE(D.TML_CRR_CD,NULL,'N','','N',DECODE(D.TML_CRR_CD,' ','N','TSG','N','Y')) --LGS_COST_CD가 'A' MODE 일 경우 CRR_CD가 NULL,' ','TSG'이외의 값이면 통과" ).append("\n"); 
		query.append("			ELSE 'Y'" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("		ELSE 'Y'" ).append("\n"); 
		query.append("		END " ).append("\n"); 
		query.append("	 WHEN COUNT(D.TML_SO_DTL_SEQ)=0 THEN 'NF'" ).append("\n"); 
		query.append("	 ELSE 'N'" ).append("\n"); 
		query.append("	 END CHK" ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND H.TML_SO_SEQ			= D.TML_SO_SEQ" ).append("\n"); 
		query.append(" AND H.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND H.TML_SO_SEQ			= @[tml_so_seq]" ).append("\n"); 
		query.append(" AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append(" AND SUBSTR(D.LGS_COST_CD,1,2) <> 'SR'" ).append("\n"); 
		query.append(" AND D.LGS_COST_CD <> 'SVLDBB'" ).append("\n"); 
		query.append(" GROUP BY D.TML_SO_OFC_CTY_CD, D.TML_SO_SEQ, H.INV_NO, D.LGS_COST_CD, D.TML_CRR_CD, H.RTRO_TML_INV_FLG" ).append("\n"); 

	}
}