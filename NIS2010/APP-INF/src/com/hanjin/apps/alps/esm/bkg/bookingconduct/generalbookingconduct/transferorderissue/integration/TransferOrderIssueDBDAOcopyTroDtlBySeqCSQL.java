/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyTroDtlBySeqCSQL.java
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

public class TransferOrderIssueDBDAOcopyTroDtlBySeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * general tro를 copy한다
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyTroDtlBySeqCSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcopyTroDtlBySeqCSQL").append("\n"); 
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
		query.append("insert into  bkg_tro_dtl(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",TRO_SUB_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TRO_QTY" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",DOR_ARR_DT" ).append("\n"); 
		query.append(",PKUP_LOC_CD" ).append("\n"); 
		query.append(",PKUP_YD_CD" ).append("\n"); 
		query.append(",RTN_LOC_CD" ).append("\n"); 
		query.append(",RTN_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",dtl.IO_BND_CD" ).append("\n"); 
		query.append(",dtl.RTN_TRO_FLG" ).append("\n"); 
		query.append(",mst.TRO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tro_seq}!='')" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append(",nvl((select max(tro_sub_seq)" ).append("\n"); 
		query.append("from bkg_tro_dtl" ).append("\n"); 
		query.append("where bkg_no 		= @[targetBkg]" ).append("\n"); 
		query.append("and io_bnd_cd 		= 'O'" ).append("\n"); 
		query.append("and rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and cxl_flg 		= 'N'" ).append("\n"); 
		query.append("and tro_seq 		= @[tro_seq]), 0) + 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--tro copy" ).append("\n"); 
		query.append(",dtl.TRO_SUB_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",dtl.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",dtl.TRO_QTY" ).append("\n"); 
		query.append(",dtl.CNTR_NO" ).append("\n"); 
		query.append(",dtl.DOR_ARR_DT" ).append("\n"); 
		query.append(",dtl.PKUP_LOC_CD" ).append("\n"); 
		query.append(",dtl.PKUP_YD_CD" ).append("\n"); 
		query.append(",dtl.RTN_LOC_CD" ).append("\n"); 
		query.append(",dtl.RTN_YD_CD" ).append("\n"); 
		query.append(",dtl.CMDT_CD" ).append("\n"); 
		query.append(",dtl.PCTL_NO" ).append("\n"); 
		query.append(",dtl.CXL_FLG" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_tro_dtl dtl, bkg_tro mst" ).append("\n"); 
		query.append("where dtl.bkg_no 		=  @[bkg_no]" ).append("\n"); 
		query.append("and dtl.io_bnd_cd 	= 'O'" ).append("\n"); 
		query.append("and dtl.rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and dtl.cxl_flg 		= 'N'" ).append("\n"); 
		query.append("and mst.bkg_no		= @[targetBkg]" ).append("\n"); 
		query.append("and mst.io_bnd_cd 	= 'O'" ).append("\n"); 
		query.append("and mst.rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and mst.cxl_flg 		= 'N'" ).append("\n"); 
		query.append("#if(${tro_seq}==''&&${tro_sub_seq} == '')" ).append("\n"); 
		query.append("--tro copy" ).append("\n"); 
		query.append("and mst.pctl_no       = dtl.tro_seq" ).append("\n"); 
		query.append("and dtl.tro_seq in (select tro_seq" ).append("\n"); 
		query.append("from bkg_tro" ).append("\n"); 
		query.append("where bkg_no 		= @[bkg_no]" ).append("\n"); 
		query.append("and io_bnd_cd 	    = 'O'" ).append("\n"); 
		query.append("and rtn_tro_flg 	= 'N'" ).append("\n"); 
		query.append("and cxl_flg		= 'N')" ).append("\n"); 
		query.append("order by mst.bkg_no, mst.tro_seq" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append("and dtl.tro_seq 		= @[tro_seq]" ).append("\n"); 
		query.append("and mst.pctl_no       = dtl.tro_seq" ).append("\n"); 
		query.append("and dtl.tro_sub_seq 	= @[tro_sub_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}