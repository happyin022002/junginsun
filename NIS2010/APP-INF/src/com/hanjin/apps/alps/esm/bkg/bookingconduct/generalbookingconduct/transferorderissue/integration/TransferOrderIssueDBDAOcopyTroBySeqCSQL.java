/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyTroBySeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.30 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcopyTroBySeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * general tro를 copy한다
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyTroBySeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcopyTroBySeqCSQL").append("\n"); 
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
		query.append("insert into bkg_tro(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",RQST_USR_ID" ).append("\n"); 
		query.append(",OWNR_TRK_FLG" ).append("\n"); 
		query.append(",ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",ACT_SHPR_NM" ).append("\n"); 
		query.append(",ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",ACT_SHPR_ADDR" ).append("\n"); 
		query.append(",ZN_CD" ).append("\n"); 
		query.append(",DOR_LOC_CD" ).append("\n"); 
		query.append(",DOR_PST_NO" ).append("\n"); 
		query.append(",BIZ_RGST_NO" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PHN_NO" ).append("\n"); 
		query.append(",CNTC_MPHN_NO" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",SO_FLG" ).append("\n"); 
		query.append(",SO_ACT_CUST_NO" ).append("\n"); 
		query.append(",SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",TRO_BKG_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tro_seq}!='')" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append(",nvl((select max(tro_seq)" ).append("\n"); 
		query.append("from bkg_tro" ).append("\n"); 
		query.append("where bkg_no 		= @[targetBkg]" ).append("\n"); 
		query.append("and io_bnd_cd 		= 'O'" ).append("\n"); 
		query.append("and rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and cxl_flg 		= 'N'), 0) + 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--tro copy" ).append("\n"); 
		query.append(",rownum" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",null RQST_DT" ).append("\n"); 
		query.append(",null RQST_USR_ID" ).append("\n"); 
		query.append(",OWNR_TRK_FLG" ).append("\n"); 
		query.append(",ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",ACT_SHPR_NM" ).append("\n"); 
		query.append(",ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",ACT_SHPR_ADDR" ).append("\n"); 
		query.append(",ZN_CD" ).append("\n"); 
		query.append(",DOR_LOC_CD" ).append("\n"); 
		query.append(",DOR_PST_NO" ).append("\n"); 
		query.append(",BIZ_RGST_NO" ).append("\n"); 
		query.append(",'N'  CFM_FLG" ).append("\n"); 
		query.append(",null CFM_DT" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PHN_NO" ).append("\n"); 
		query.append(",CNTC_MPHN_NO" ).append("\n"); 
		query.append(",'N' CXL_FLG" ).append("\n"); 
		query.append(",'N' SO_FLG" ).append("\n"); 
		query.append(",null SO_ACT_CUST_NO" ).append("\n"); 
		query.append(",null SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",tro_seq      PCTL_NO  --cancel을 제외하고 seq를 1부터 딴 다음 bkg_tro_dtl에 seq를 유지하기 위해 임시로 넣음" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",null TRO_BKG_NO" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_tro" ).append("\n"); 
		query.append("where bkg_no 		= @[bkg_no]" ).append("\n"); 
		query.append("and io_bnd_cd 	= 'O'" ).append("\n"); 
		query.append("and rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and cxl_flg 		= 'N'" ).append("\n"); 
		query.append("#if(${tro_seq}!='')" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append("and tro_seq 		= @[tro_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("order by bkg_no, tro_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}