/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchMultiBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchMultiBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchMultiBkgRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchMultiBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchMultiBkgRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT C.BKG_NO" ).append("\n"); 
		query.append(", DECODE(NVL(CFM_FLG, 'N'), 'N', 'NO', 'YES') TRO_I" ).append("\n"); 
		query.append(", NVL(DECODE(COP_NO, MST_COP_NO, 'YES', 'NO'), 'NO') MASTER" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO A, SCE_COP_HDR B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE C.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO        = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_NO        = A.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("AND C.CNTR_NO       = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO       = A.CNTR_NO(+)" ).append("\n"); 
		query.append("AND @[bound_cd]     = A.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND 'N'             = A.CXL_FLG(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT CNTR2.BKG_NO" ).append("\n"); 
		query.append(", DECODE(NVL(TRO2.TRO_SEQ, 0), 0, 'NO', 'YES') TRO_I" ).append("\n"); 
		query.append(", NVL(DECODE(SCE.COP_NO, MST_COP_NO, 'YES', 'NO'), 'NO') MASTER" ).append("\n"); 
		query.append("FROM BKG_CONTAINER    CNTR1" ).append("\n"); 
		query.append(", BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append(", BKG_BOOKING   BK2" ).append("\n"); 
		query.append(", BKG_EUR_TRO   TRO2" ).append("\n"); 
		query.append(", SCE_COP_HDR   SCE" ).append("\n"); 
		query.append("WHERE CNTR1.CNTR_NO   = @[cntr_no]" ).append("\n"); 
		query.append("AND CNTR1.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR1.BKG_NO      <> BK2.BKG_NO" ).append("\n"); 
		query.append("AND BK2.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND BK2.BKG_NO        = CNTR2.BKG_NO" ).append("\n"); 
		query.append("AND CNTR1.CNTR_NO     = CNTR2.CNTR_NO" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_ID_NO , 0)   = nvl(CNTR2.CNMV_ID_NO , 0)" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_CYC_NO, 0)   = nvl(CNTR2.CNMV_CYC_NO, 0)" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_YR    , 'X') = nvl(CNTR2.CNMV_YR    , 'X')" ).append("\n"); 
		query.append("AND CNTR2.BKG_NO      = TRO2.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR2.CNTR_NO     = TRO2.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CNTR2.BKG_NO      = SCE.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR2.CNTR_NO     = SCE.CNTR_NO(+)" ).append("\n"); 
		query.append("AND @[bound_cd]       = TRO2.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND 'N'               = TRO2.CXL_FLG(+)" ).append("\n"); 
		query.append("AND 'Y'               = TRO2.CFM_FLG(+)" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}