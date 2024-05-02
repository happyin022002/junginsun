/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsBLVOLInfo
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL(){
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
		params.put("v_pol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("v_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL").append("\n"); 
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
		query.append(" 'SMLM'||B.BL_NO BL_NO" ).append("\n"); 
		query.append(",B.BKG_NO BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_gubun}=='1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'22' BL_IND        --Mode=Outbound 조건       --22-Export" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'23' BL_IND        --Mode=Inbound 조건    --23-Import" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BD.PCK_QTY BL_PKG" ).append("\n"); 
		query.append(",BD.PCK_TP_CD BLPKG_UNIT" ).append("\n"); 
		query.append(",BD.ACT_WGT     BL_WGT" ).append("\n"); 
		query.append(",BD.WGT_UT_CD   BLWGT_UNIT" ).append("\n"); 
		query.append(",SUM(BQ.OP_CNTR_QTY) BL_VOL" ).append("\n"); 
		query.append(",'MTQ' BLVOL_UNIT" ).append("\n"); 
		query.append(",BD.MEAS_QTY    BL_MEA" ).append("\n"); 
		query.append(",BD.MEAS_UT_CD  BLMEA_UNIT" ).append("\n"); 
		query.append(",B.CMDT_CD      COMMODITY_CD" ).append("\n"); 
		query.append("FROM      BKG_VVD V" ).append("\n"); 
		query.append(", BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_BL_DOC BD" ).append("\n"); 
		query.append(", BKG_CONTAINER BC" ).append("\n"); 
		query.append(", BKG_QUANTITY BQ" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       V.VSL_CD = SUBSTR(@[vvd],1,4)                --[vvd]" ).append("\n"); 
		query.append("AND       V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)            --[vvd]" ).append("\n"); 
		query.append("AND       V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)            --[vvd]" ).append("\n"); 
		query.append("AND		  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${pol_gubun}=='1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       V.POL_CD = @[v_pol]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       V.POD_CD = @[v_pod]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND       B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND       BD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND       BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND       BQ.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND       BQ.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP BY B.BL_NO" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append("--BL_IND" ).append("\n"); 
		query.append(",BD.ACT_WGT     " ).append("\n"); 
		query.append(",BD.WGT_UT_CD   " ).append("\n"); 
		query.append("--,BQ.OP_CNTR_QTY " ).append("\n"); 
		query.append("--,'MTQ' BLVOL_UNIT" ).append("\n"); 
		query.append(",BD.MEAS_QTY    " ).append("\n"); 
		query.append(",BD.MEAS_UT_CD  " ).append("\n"); 
		query.append(",B.CMDT_CD      " ).append("\n"); 
		query.append(",BD.PCK_QTY" ).append("\n"); 
		query.append(",BD.PCK_TP_CD" ).append("\n"); 

	}
}