/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodLastHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodLastHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 마지막으로 변경된 이력을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodLastHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodLastHistoryRSQL").append("\n"); 
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
		query.append("select cod.cod_sts_cd" ).append("\n"); 
		query.append(", to_char(his.evnt_dt, 'yyyy-mm-dd') update_date" ).append("\n"); 
		query.append(", his.upd_usr_id update_by" ).append("\n"); 
		query.append(", (select ofc_cd from com_user usr where usr.usr_id = his.upd_usr_id) update_ofc" ).append("\n"); 
		query.append(", decode(his.cod_sts_Cd,null,'',his.cod_sts_Cd    ||':'||(select INTG_CD_VAL_DP_DESC from com_intg_cd_dtl cd where cd.INTG_CD_ID = 'CD02124' and cd.INTG_CD_VAL_CTNT = his.COD_STS_CD)) now_read" ).append("\n"); 
		query.append(", decode(pre_his.cod_sts_Cd,null,'',pre_his.cod_sts_Cd||':'||(select INTG_CD_VAL_DP_DESC from com_intg_cd_dtl cd where cd.INTG_CD_ID = 'CD02124' and cd.INTG_CD_VAL_CTNT = pre_his.COD_STS_CD)) previous" ).append("\n"); 
		query.append("from bkg_cod cod, bkg_cod_his his, bkg_cod_his pre_his" ).append("\n"); 
		query.append("where cod.bkg_no = his.bkg_no" ).append("\n"); 
		query.append("and cod.cod_rqst_seq = his.cod_rqst_seq" ).append("\n"); 
		query.append("and his.bkg_no = pre_his.bkg_no(+)" ).append("\n"); 
		query.append("and his.cod_rqst_seq = pre_his.cod_rqst_seq(+)" ).append("\n"); 
		query.append("and his.cod_his_Seq - 1 = pre_his.cod_his_seq(+)" ).append("\n"); 
		query.append("and his.COD_HIS_SEQ = (select max(COD_HIS_SEQ)" ).append("\n"); 
		query.append("from bkg_cod_his his2" ).append("\n"); 
		query.append("where his.bkg_no = his2.bkg_no" ).append("\n"); 
		query.append("and his.cod_rqst_seq = his2.cod_rqst_seq)" ).append("\n"); 
		query.append("#if (${bkgNo} !='')" ).append("\n"); 
		query.append("and cod.bkg_no = @[bkgNo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${codRqstSeq} !='')" ).append("\n"); 
		query.append("and cod.cod_rqst_Seq =  @[codRqstSeq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}