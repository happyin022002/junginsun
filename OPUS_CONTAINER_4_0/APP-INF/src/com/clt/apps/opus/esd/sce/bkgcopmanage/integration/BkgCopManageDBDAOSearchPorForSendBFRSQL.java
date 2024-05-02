/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchPorForSendBFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.05 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchPorForSendBFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BF edi status 를 전송하기 위하여 POR 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchPorForSendBFRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchPorForSendBFRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT cntr_no," ).append("\n"); 
		query.append("b.bkg_no," ).append("\n"); 
		query.append("nod_cd," ).append("\n"); 
		query.append("act_dt," ).append("\n"); 
		query.append("b.cop_no," ).append("\n"); 
		query.append("'BF' as edi_stnd_sts_cd," ).append("\n"); 
		query.append("'COP' as cre_usr_id" ).append("\n"); 
		query.append("FROM edi_grp_cgo cgo," ).append("\n"); 
		query.append("edi_grp_cust cust," ).append("\n"); 
		query.append("bkg_customer bcust," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[cntr_no] as cntr_no," ).append("\n"); 
		query.append("@[bkg_no] as bkg_no," ).append("\n"); 
		query.append("por_nod_cd as nod_cd," ).append("\n"); 
		query.append("cop_no," ).append("\n"); 
		query.append("TO_CHAR( GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, substr(por_nod_cd, 1, 5)), 'YYYYMMDDHH24MISS' ) act_dt" ).append("\n"); 
		query.append("FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND cntr_no = @[cntr_no] ) b" ).append("\n"); 
		query.append("WHERE cgo.edi_stnd_sts_cd = 'BF'" ).append("\n"); 
		query.append("AND cgo.edi_grp_cd = cust.edi_grp_cd" ).append("\n"); 
		query.append("AND cust.cust_cnt_cd = bcust.cust_cnt_cd" ).append("\n"); 
		query.append("AND cust.cust_seq = bcust.cust_seq" ).append("\n"); 
		query.append("AND bcust.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT cntr_no," ).append("\n"); 
		query.append("b.bkg_no," ).append("\n"); 
		query.append("nod_cd," ).append("\n"); 
		query.append("act_dt," ).append("\n"); 
		query.append("b.cop_no," ).append("\n"); 
		query.append("'BF' as edi_stnd_sts_cd," ).append("\n"); 
		query.append("'COP' as cre_usr_id" ).append("\n"); 
		query.append("FROM edi_grp_cgo cgo," ).append("\n"); 
		query.append("edi_grp_cust cust," ).append("\n"); 
		query.append("bkg_booking bkg," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[cntr_no] as cntr_no," ).append("\n"); 
		query.append("@[bkg_no] as bkg_no," ).append("\n"); 
		query.append("por_nod_cd as nod_cd," ).append("\n"); 
		query.append("cop_no," ).append("\n"); 
		query.append("TO_CHAR( GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, substr(por_nod_cd, 1, 5)), 'YYYYMMDDHH24MISS' ) act_dt" ).append("\n"); 
		query.append("FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND cntr_no = @[cntr_no] ) b" ).append("\n"); 
		query.append("WHERE cgo.edi_stnd_sts_cd = 'BF'" ).append("\n"); 
		query.append("AND cgo.edi_grp_cd = cust.edi_grp_cd" ).append("\n"); 
		query.append("AND cust.sc_no = DECODE(cust.bkg_ctrt_div_cd, '1', bkg.sc_no, '2', bkg.rfa_no)" ).append("\n"); 
		query.append("AND bkg.bkg_no = b.bkg_no" ).append("\n"); 

	}
}