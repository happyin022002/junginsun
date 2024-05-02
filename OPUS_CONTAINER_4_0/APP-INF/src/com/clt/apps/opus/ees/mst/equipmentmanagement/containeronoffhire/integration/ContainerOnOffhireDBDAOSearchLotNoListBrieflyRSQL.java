/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchLotNoListBrieflyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchLotNoListBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLotNoListBriefly
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchLotNoListBrieflyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchLotNoListBrieflyRSQL").append("\n"); 
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
		query.append(" LOT_PLN_YR" ).append("\n"); 
		query.append(",LOT_LOC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",LOT_SEQ " ).append("\n"); 
		query.append(",AGMT_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(AGMT_CTY_CD, AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append(",LOT_CNTR_PFX_CD" ).append("\n"); 
		query.append(",FM_SER_NO" ).append("\n"); 
		query.append(",TO_SER_NO" ).append("\n"); 
		query.append("FROM MST_CNTR_LOT A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.OWN_CNTR_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("AND LOT_CNTR_PFX_CD = @[lot_cntr_pfx_cd]" ).append("\n"); 
		query.append("AND TO_NUMBER(@[fm_ser_no]) >= TO_NUMBER(A.FM_SER_NO) AND TO_NUMBER(@[fm_ser_no]) <= TO_NUMBER(A.TO_SER_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${de_yrmon} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(A.MFT_DT,'YYYY') = @[de_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}