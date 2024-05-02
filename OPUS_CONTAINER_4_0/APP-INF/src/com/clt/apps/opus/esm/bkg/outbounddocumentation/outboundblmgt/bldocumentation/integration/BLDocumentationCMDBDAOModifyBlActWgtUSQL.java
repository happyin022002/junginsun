/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyBlActWgtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.05.03 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyBlActWgtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * act_wgt와 wgt_ut_cd를 update한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyBlActWgtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyBlActWgtUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("merge into bkg_bl_doc_his bl" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("merge into bkg_bl_doc bl" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("using ( select bk.bkg_no" ).append("\n"); 
		query.append("				  , (SELECT VSL_ENG_NM||' '||VSK.OB_CSSM_VOY_NO " ).append("\n"); 
		query.append("           			 FROM MDM_VSL_CNTR MDM, " ).append("\n"); 
		query.append("						  VSK_VSL_PORT_SKD VSK, " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("						  BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						  BKG_VVD VVD						" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		             WHERE 1=1" ).append("\n"); 
		query.append("		               AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("		               AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("		               AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("		               AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("		               AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("		               AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("		               AND VVD.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("			   		   AND VVD.CORR_NO       = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		               AND ROWNUM =1" ).append("\n"); 
		query.append("		           ) AS VSL_NM" ).append("\n"); 
		query.append("				, (select vsl_eng_nm||' '||VSK.OB_CSSM_VOY_NO " ).append("\n"); 
		query.append("           			 FROM MDM_VSL_CNTR MDM, " ).append("\n"); 
		query.append("						  VSK_VSL_PORT_SKD VSK, " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("						  BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						  BKG_VVD VVD						" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				    where mdm.vsl_cd         = vvd.vsl_cd" ).append("\n"); 
		query.append("				      and vvd.vsl_pre_pst_cd = 'S'" ).append("\n"); 
		query.append("				      and vvd.vsl_seq        = '1'" ).append("\n"); 
		query.append("					  AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("		              AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("		              AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("		              AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("		              AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("			   		   AND VVD.CORR_NO       = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		              AND ROWNUM =1 " ).append("\n"); 
		query.append("	  			  ) pre_vsl_nm      " ).append("\n"); 
		query.append("                , bk.por_cd" ).append("\n"); 
		query.append("                , (select LOC_NM from mdm_location where loc_cd = bk.por_cd) por_nm" ).append("\n"); 
		query.append("                , bk.pol_cd" ).append("\n"); 
		query.append("                , (select LOC_NM from mdm_location where loc_cd = bk.pol_cd) pol_nm" ).append("\n"); 
		query.append("                , bk.pod_cd" ).append("\n"); 
		query.append("                , (select LOC_NM from mdm_location where loc_cd = bk.pod_cd) pod_nm" ).append("\n"); 
		query.append("                , bk.del_cd" ).append("\n"); 
		query.append("                , decode(bk.rcv_term_cd, 'Y', nvl(del_nm.attr_ctnt2, del.loc_nm), del.loc_nm) del_nm" ).append("\n"); 
		query.append("				-- NEW DELHI set 추가 Y term인 경우에 한해서	" ).append("\n"); 
		query.append("				--, decode(bk.rcv_term_cd, 'Y', decode(NVL(bk.del_nod_cd, ' '), " ).append("\n"); 
		query.append("				--						'INDELY1', 'ICD TUGHLAKABAD,NEW DELHI'," ).append("\n"); 
		query.append("				--						'INDELY2', 'ICD PATPARGANJ, NEW DELHI'," ).append("\n"); 
		query.append("		  		--						(select LOC_NM from mdm_location where loc_cd = bk.del_cd))," ).append("\n"); 
		query.append("				--					(select LOC_NM from mdm_location where loc_cd = bk.del_cd))del_nm" ).append("\n"); 
		query.append("		  from mdm_location del" ).append("\n"); 
		query.append("             , bkg_hrd_cdg_ctnt del_nm" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("             , bkg_bkg_his bk" ).append("\n"); 
		query.append("         where bk.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("   		   AND bk.CORR_NO       = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , bkg_booking bk" ).append("\n"); 
		query.append("         where bk.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           and bk.del_nod_cd 	= del_nm.attr_ctnt1(+)" ).append("\n"); 
		query.append("           and 'BL_DEL_NAME'    = del_nm.hrd_cdg_id(+)" ).append("\n"); 
		query.append("           and bk.del_cd        = del.loc_cd) bk" ).append("\n"); 
		query.append("    on (bl.bkg_no = bk.bkg_no)" ).append("\n"); 
		query.append("  WHEN matched then" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("   set bl.ACT_WGT       = to_number(decode(@[act_wgt],   'X', bl.ACT_WGT,   @[act_wgt]))--cod에서 update시 'X'임" ).append("\n"); 
		query.append("        , bl.WGT_UT_CD  = decode(@[wgt_ut_cd], 'X', bl.WGT_UT_CD, @[wgt_ut_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_update} == 'Y') " ).append("\n"); 
		query.append("		, bl.vsl_nm		= bk.vsl_nm" ).append("\n"); 
		query.append("		, bl.pre_vsl_nm	= bk.pre_vsl_nm" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        --, bl.por_cd     = bk.por_cd" ).append("\n"); 
		query.append("        , bl.por_cd     = decode(bl.por_cd, bk.por_cd, bl.por_cd, bk.por_cd)" ).append("\n"); 
		query.append("        , bl.pol_cd     = decode(bl.pol_cd, bk.pol_cd, bl.pol_cd, bk.pol_cd)" ).append("\n"); 
		query.append("        , bl.pod_cd     = decode(bl.pod_cd, bk.pod_cd, bl.pod_cd, bk.pod_cd)" ).append("\n"); 
		query.append("        , bl.del_cd     = decode(bl.del_cd, bk.del_cd, bl.del_cd, bk.del_cd)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , bl.por_nm     = decode(bl.por_cd, bk.por_cd, bl.por_nm, bk.por_nm)" ).append("\n"); 
		query.append("        , bl.pol_nm     = decode(bl.pol_cd, bk.pol_cd, bl.pol_nm, bk.pol_nm)" ).append("\n"); 
		query.append("        , bl.pod_nm     = decode(bl.pod_cd, bk.pod_cd, bl.pod_nm, bk.pod_nm)" ).append("\n"); 
		query.append("        , bl.del_nm     = decode(bl.del_cd, bk.del_cd, bl.del_nm, bk.del_nm)" ).append("\n"); 
		query.append("        , bl.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        , bl.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE bl.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   AND bl.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}