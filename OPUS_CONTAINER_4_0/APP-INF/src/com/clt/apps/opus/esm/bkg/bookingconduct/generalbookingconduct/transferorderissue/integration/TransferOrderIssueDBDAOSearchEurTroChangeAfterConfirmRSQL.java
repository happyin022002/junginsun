/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroChangeAfterConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.07.11 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroChangeAfterConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search change after confirm
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroChangeAfterConfirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroChangeAfterConfirmRSQL").append("\n"); 
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
		query.append("SELECT MST.BKG_NO" ).append("\n"); 
		query.append("	  ,MST.TRO_SEQ" ).append("\n"); 
		query.append("	  ,MST.CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append("	  ,MST.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(MST.CNTR_RTN_DT,'YYYYMMDDHH24MISS') CNTR_RTN_DT" ).append("\n"); 
		query.append("	  ,MST.HLG_TP_CD" ).append("\n"); 
		query.append("	  ,MST.CNTR_NO" ).append("\n"); 
		query.append("	  ,MST.BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("	  ,DTL.ZN_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO MST" ).append("\n"); 
		query.append("LEFT OUTER JOIN BKG_EUR_TRO_DTL DTL" ).append("\n"); 
		query.append("ON MST.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("AND MST.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("AND MST.TRO_SEQ = DTL.TRO_SEQ" ).append("\n"); 
		query.append("AND DTL.MLT_STOP_SEQ = 1" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#if (${tro_seq} != '') " ).append("\n"); 
		query.append("AND MST.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(MST.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(MST.CXL_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}