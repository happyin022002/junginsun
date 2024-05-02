/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchMGSetFuelingChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.19 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchMGSetFuelingChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMGSetFuelingChargeList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchMGSetFuelingChargeListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchMGSetFuelingChargeListRSQL").append("\n"); 
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
		query.append("SELECT M.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", M.TML_SO_SEQ" ).append("\n"); 
		query.append(", M.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(", M.MGST_NO" ).append("\n"); 
		query.append(", M.YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(M.FUEL_DT, 'YYYYMMDD') AS FUEL_DT" ).append("\n"); 
		query.append(", M.MGST_RUN_HRS" ).append("\n"); 
		query.append(", M.CURR_CD" ).append("\n"); 
		query.append(", M.FUEL_RT" ).append("\n"); 
		query.append(", M.FUEL_AMT" ).append("\n"); 
		query.append(", M.LBR_AMT" ).append("\n"); 
		query.append(", M.TTL_AMT" ).append("\n"); 
		query.append(", M.CHSS_NO" ).append("\n"); 
		query.append(", M.RF_CNTR_NO" ).append("\n"); 
		query.append(", M.WO_NO" ).append("\n"); 
		query.append(", M.FUEL_QTY" ).append("\n"); 
		query.append(", 'DB' AS FROM_WHERE" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_MGST_FUEL_CHG M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N')<>'Y'" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = M.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = M.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = M.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 

	}
}