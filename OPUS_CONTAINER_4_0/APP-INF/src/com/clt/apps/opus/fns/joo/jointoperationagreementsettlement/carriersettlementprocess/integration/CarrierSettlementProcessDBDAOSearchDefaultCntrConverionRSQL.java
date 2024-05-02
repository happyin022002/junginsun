/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchDefaultCntrConverionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchDefaultCntrConverionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Default TP/SZ TEU Search
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchDefaultCntrConverionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dft_tpsz_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchDefaultCntrConverionRSQL").append("\n"); 
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
		query.append("SELECT DFT.PPT_CD" ).append("\n"); 
		query.append("     , DFT.LINE_SEQ" ).append("\n"); 
		query.append("     , DFT.ATTR_CTNT1 AS DFT_TPSZ_GROUP /*F : Laden, E : Empty*/" ).append("\n"); 
		query.append("     , DFT.ATTR_CTNT2 AS DFT_TPSZ" ).append("\n"); 
		query.append("     , NVL(TEU.TEU_CNT, ATTR_CTNT3) AS DFT_TEU_CNT" ).append("\n"); 
		query.append("     , TEU.TEU_CNT" ).append("\n"); 
		query.append("     , DFT.ATTR_CTNT4 AS DFT_RF_PLUG_FLG     " ).append("\n"); 
		query.append("  FROM JOO_COM_PPT DFT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT DISTINCT ATTR_CTNT1 AS SLAN_CD" ).append("\n"); 
		query.append("             , ATTR_CTNT2 AS TGT_NORMAL_TPSZ" ).append("\n"); 
		query.append("             , ATTR_CTNT3 AS TEU_CNT" ).append("\n"); 
		query.append("          FROM JOO_COM_PPT A" ).append("\n"); 
		query.append("         WHERE A.PPT_CD     = 'TEU CONVERSION' " ).append("\n"); 
		query.append("           AND A.ATTR_CTNT1 = @[slan_cd]" ).append("\n"); 
		query.append("       ) TEU" ).append("\n"); 
		query.append(" WHERE DFT.PPT_CD       = 'DEFAULT TPSZ'" ).append("\n"); 
		query.append("   AND DFT.ATTR_CTNT1   = @[dft_tpsz_group]" ).append("\n"); 
		query.append("   AND DFT.ATTR_CTNT2   = TEU.TGT_NORMAL_TPSZ(+)" ).append("\n"); 
		query.append(" ORDER BY DFT.ATTR_CTNT1 DESC, DFT.LINE_SEQ" ).append("\n"); 

	}
}