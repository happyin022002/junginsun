/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetInboundDivideVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetInboundDivideVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 해당 Inbound Volume(Ton) / VesselVolume(FR)를 구한다.
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetInboundDivideVesselRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetInboundDivideVesselRSQL").append("\n"); 
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
		query.append("SELECT ROUND(DECODE(NVL(VSL_VOL,0),0,'',INB_TON/VSL_VOL),4)" ).append("\n"); 
		query.append("  FROM (SELECT SUM(NVL(WEIGHT,0)) INB_TON" ).append("\n"); 
		query.append("             , TRUNC(ROUND(MAX(M.LOA_LEN),1)*MAX(M.VSL_WDT) * ROUND(SQRT(ROUND(MAX(M.LOA_LEN),1)*MAX(M.VSL_WDT)) * 0.14, 1 )) VSL_VOL" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("             , TDR_HEADER H" ).append("\n"); 
		query.append("             , TDR_SUMMARY S" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR M" ).append("\n"); 
		query.append("         WHERE V.VSL_CD         = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO     = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD     = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND V.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("           AND V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("           AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND V.VSL_CD         = M.VSL_CD" ).append("\n"); 
		query.append("           AND V.VSL_CD         = H.VSL_CD" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO     = H.VOY_NO" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD     = H.DIR_CD" ).append("\n"); 
		query.append("           AND V.VPS_PORT_CD    = H.PORT_CD" ).append("\n"); 
		query.append("           AND V.CLPT_IND_SEQ   = H.CALL_IND" ).append("\n"); 
		query.append("           AND H.VSL_CD         = S.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO         = S.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD         = S.DIR_CD" ).append("\n"); 
		query.append("           AND H.PORT_CD        = S.PORT_CD" ).append("\n"); 
		query.append("           AND H.CALL_IND       = S.CALL_IND" ).append("\n"); 
		query.append("           AND S.STATUS IN ('DS','DT') " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}