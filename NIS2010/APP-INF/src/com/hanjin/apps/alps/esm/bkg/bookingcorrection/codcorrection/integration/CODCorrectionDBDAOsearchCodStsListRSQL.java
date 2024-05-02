/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD의 요청,승인,거절 등의 이력을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodStsListRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dur_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dur_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodStsListRSQL").append("\n"); 
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
		query.append("select seq_no" ).append("\n"); 
		query.append(", bkg_no" ).append("\n"); 
		query.append(", cod_rqst_seq" ).append("\n"); 
		query.append(", old_por" ).append("\n"); 
		query.append(", old_pol" ).append("\n"); 
		query.append(", old_pod" ).append("\n"); 
		query.append(", old_del" ).append("\n"); 
		query.append(", old_pre" ).append("\n"); 
		query.append(", old_post" ).append("\n"); 
		query.append(", old_t_vvd" ).append("\n"); 
		query.append(", new_por" ).append("\n"); 
		query.append(", new_pol" ).append("\n"); 
		query.append(", new_pod" ).append("\n"); 
		query.append(", new_del" ).append("\n"); 
		query.append(", new_pre" ).append("\n"); 
		query.append(", new_post" ).append("\n"); 
		query.append(", new_t_vvd" ).append("\n"); 
		query.append(", cntr_qty" ).append("\n"); 
		query.append(", approval_result" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(select  ROW_NUMBER() OVER (order by cod.cod_iss_dt,cod.bkg_no) seq_no" ).append("\n"); 
		query.append(", cod.bkg_no" ).append("\n"); 
		query.append(", cod.cod_rqst_seq" ).append("\n"); 
		query.append(", substr(cod.old_por_yd_cd,1,5) old_por" ).append("\n"); 
		query.append(", substr(cod.old_pol_yd_cd,1,5) old_pol" ).append("\n"); 
		query.append(", substr(cod.old_pod_yd_cd,1,5) old_pod" ).append("\n"); 
		query.append(", substr(cod.old_del_yd_cd,1,5) old_del" ).append("\n"); 
		query.append(", decode(substr(cod.old_pol_yd_cd,1,5), substr(old_tvvd.pol_yd_cd,1,5), null, substr(old_tvvd.pol_yd_cd,1,5)) old_pre" ).append("\n"); 
		query.append(", decode(substr(cod.old_pod_yd_cd,1,5), substr(old_tvvd.pod_yd_cd,1,5), null, substr(old_tvvd.pod_yd_cd,1,5)) old_post" ).append("\n"); 
		query.append(", cod.old_vsl_cd||cod.old_skd_voy_no||cod.old_skd_dir_cd old_t_vvd" ).append("\n"); 
		query.append(", substr(cod.new_por_yd_cd,1,5) new_por" ).append("\n"); 
		query.append(", substr(cod.new_pol_yd_cd,1,5) new_pol" ).append("\n"); 
		query.append(", substr(cod.new_pod_yd_cd,1,5) new_pod" ).append("\n"); 
		query.append(", substr(cod.new_del_yd_cd,1,5) new_del" ).append("\n"); 
		query.append(", decode(substr(cod.new_pol_yd_cd,1,5), substr(new_tvvd.pol_yd_cd,1,5), null, substr(new_tvvd.pol_yd_cd,1,5)) new_pre" ).append("\n"); 
		query.append(", decode(substr(cod.new_pod_yd_cd,1,5), substr(new_tvvd.pod_yd_cd,1,5), null, substr(new_tvvd.pod_yd_cd,1,5)) new_post" ).append("\n"); 
		query.append(", cod.new_vsl_cd||cod.new_skd_voy_no||cod.new_skd_dir_cd new_t_vvd" ).append("\n"); 
		query.append(", (select count(1) from bkg_cod_cntr cntr where cod.bkg_no = cntr.bkg_no and cod.cod_rqst_Seq = cntr.cod_rqst_seq) cntr_qty" ).append("\n"); 
		query.append(", cod.cod_sts_cd approval_result" ).append("\n"); 
		query.append("from bkg_cod cod" ).append("\n"); 
		query.append(", bkg_cod_vvd old_tvvd" ).append("\n"); 
		query.append(", bkg_cod_vvd new_tvvd" ).append("\n"); 
		query.append(", bkg_booking bk" ).append("\n"); 
		query.append("#if (${bkg_no} =='' && ${vvd} !='' )" ).append("\n"); 
		query.append(", bkg_vvd vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where cod.bkg_no           = bk.bkg_no" ).append("\n"); 
		query.append("and cod.bkg_no           = old_tvvd.bkg_no        (+)" ).append("\n"); 
		query.append("and cod.cod_rqst_Seq     = old_tvvd.cod_rqst_seq  (+)" ).append("\n"); 
		query.append("and cod.bkg_no           = new_tvvd.bkg_no        (+)" ).append("\n"); 
		query.append("and cod.cod_rqst_Seq     = new_tvvd.cod_rqst_seq  (+)" ).append("\n"); 
		query.append("and 'O'                  = old_tvvd.vvd_op_cd     (+)" ).append("\n"); 
		query.append("and 'T'                  = old_tvvd.vsl_pre_pst_cd(+)" ).append("\n"); 
		query.append("and 'N'                  = new_tvvd.vvd_op_cd     (+)" ).append("\n"); 
		query.append("and 'T'                  = new_tvvd.vsl_pre_pst_cd(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("and bk.bkg_no            = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${dur_from} !='' && ${dur_to} !='')" ).append("\n"); 
		query.append("and to_date(@[dur_from], 'yyyy-mm-dd')      < nvl(cod.cod_iss_dt, (select max(evnt_dt) from bkg_cod_his his where his.bkg_no = cod.bkg_no and cod_sts_cd = 'R'))" ).append("\n"); 
		query.append("and to_date(@[dur_to],   'yyyy-mm-dd') + 1  > nvl(cod.cod_iss_dt, (select max(evnt_dt) from bkg_cod_his his where his.bkg_no = cod.bkg_no and cod_sts_cd = 'R'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} !='' )" ).append("\n"); 
		query.append("and bk.bkg_ofc_cd        = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='' )" ).append("\n"); 
		query.append("and bk.pol_cd            = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} !='' )" ).append("\n"); 
		query.append("and cod.bkg_no           = vvd.bkg_no" ).append("\n"); 
		query.append("and vvd.vsl_cd           = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("and vvd.skd_voy_no       = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("and vvd.skd_dir_cd       = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cod_sts_cd} !='A' )" ).append("\n"); 
		query.append("and cod.cod_sts_cd       = @[cod_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if (${startno} != \"\")" ).append("\n"); 
		query.append("and seq_no BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}