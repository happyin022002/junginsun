/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOmodifyMyBiddingDtlListDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.07.05 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOmodifyMyBiddingDtlListDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정 - EES_MNR_S304 화면에서 수정
	  * </pre>
	  */
	public DisposalMgtDBDAOmodifyMyBiddingDtlListDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("part_disp_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("part_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOmodifyMyBiddingDtlListDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DISP_BUYR_DTL_PART MBDP" ).append("\n"); 
		query.append("SET MBDP.DISP_QTY        = @[part_disp_qty]" ).append("\n"); 
		query.append(", MBDP.VNDR_BID_KNT      =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DECODE(ROUND(X.PART_UT_AMT),@[part_ut_amt],NVL(X.VNDR_BID_KNT,0),(NVL(X.VNDR_BID_KNT,0) + 1))" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART X" ).append("\n"); 
		query.append("WHERE X.DISP_NO       = @[disp_no]" ).append("\n"); 
		query.append("AND X.DISP_DTL_SEQ    = @[disp_dtl_seq]" ).append("\n"); 
		query.append("AND X.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("AND X.MNR_PRNR_SEQ    = @[mnr_prnr_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MBDP.PART_UT_AMT       = @[part_ut_amt]" ).append("\n"); 
		query.append(", MBDP.MNR_DISP_DTL_RMK  = @[mnr_disp_dtl_rmk]" ).append("\n"); 
		query.append(", MBDP.UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(", MBDP.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(", MBDP.VNDR_BID_TMS      = SYSTIMESTAMP" ).append("\n"); 
		query.append("WHERE MBDP.DISP_NO       = @[disp_no]" ).append("\n"); 
		query.append("AND MBDP.DISP_DTL_SEQ    = @[disp_dtl_seq]" ).append("\n"); 
		query.append("AND MBDP.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("AND MBDP.MNR_PRNR_SEQ    = @[mnr_prnr_seq]" ).append("\n"); 

	}
}