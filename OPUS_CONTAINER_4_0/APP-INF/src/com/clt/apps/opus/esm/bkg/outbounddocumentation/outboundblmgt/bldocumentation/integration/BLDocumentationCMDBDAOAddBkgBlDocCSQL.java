/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOAddBkgBlDocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOAddBkgBlDocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BL_DOC 저장
	  * </pre>
	  */
	public BLDocumentationCMDBDAOAddBkgBlDocCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_dest_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOAddBkgBlDocCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_bl_doc" ).append("\n"); 
		query.append("        (bkg_no" ).append("\n"); 
		query.append("		, act_wgt" ).append("\n"); 
		query.append("		, act_wgt_prn_flg" ).append("\n"); 
		query.append("		, wgt_ut_cd" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD" ).append("\n"); 
		query.append("        , bl_mv_tp_NM" ).append("\n"); 
		query.append("        , vsl_nm" ).append("\n"); 
		query.append("        , pre_vsl_nm" ).append("\n"); 
		query.append("        , por_cd" ).append("\n"); 
		query.append("        , por_nm" ).append("\n"); 
		query.append("        , pol_cd" ).append("\n"); 
		query.append("        , pol_nm" ).append("\n"); 
		query.append("        , pod_cd" ).append("\n"); 
		query.append("        , pod_nm" ).append("\n"); 
		query.append("        , del_cd" ).append("\n"); 
		query.append("        , del_nm" ).append("\n"); 
		query.append("        , fnl_dest_nm" ).append("\n"); 
		query.append("        , cre_usr_id" ).append("\n"); 
		query.append("        , cre_dt" ).append("\n"); 
		query.append("        , upd_usr_id" ).append("\n"); 
		query.append("        , upd_dt)" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append("		, @[act_wgt]" ).append("\n"); 
		query.append("		, 'Y'" ).append("\n"); 
		query.append("		, @[wgt_ut_cd]" ).append("\n"); 
		query.append("        , 0" ).append("\n"); 
		query.append("        , NVL((SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID = @[cre_usr_id]),'CBM') AS MEAS_UT_CD" ).append("\n"); 
		query.append("		, DECODE(BK.RCV_TERM_CD||BK.DE_TERM_CD,'YY',1 ,'YD',1 ,'YS',3 ,'YT',10,'YO',11,'YM',2 " ).append("\n"); 
		query.append("										      ,'DY',1 ,'DD',1 ,'DS',3 ,'DT',10,'DO',11,'DM',2 " ).append("\n"); 
		query.append("											  ,'SY',7 ,'SD',7 ,'SS',9 ,'ST',14,'SO',15,'SM',8 " ).append("\n"); 
		query.append("										      ,'TY',16,'TD',16,'TS',18,'TT',19,'TO',20,'TM',17" ).append("\n"); 
		query.append("											  ,'IY',21,'ID',21,'IS',23,'IT',24,'IO',25,'IM',22" ).append("\n"); 
		query.append("											  ,'MY',4 ,'MD',4 ,'MS',6 ,'MT',12,'MO',13,'MM',5 )" ).append("\n"); 
		query.append("        , (SELECT VSL_ENG_NM||' '||VSK.OB_CSSM_VOY_NO " ).append("\n"); 
		query.append("           FROM MDM_VSL_CNTR MDM, VSK_VSL_PORT_SKD VSK, BKG_VVD VVD" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("             AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("             AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("             AND VVD.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("             AND ROWNUM =1" ).append("\n"); 
		query.append("           ) AS VSL_NM" ).append("\n"); 
		query.append("		, (select vsl_eng_nm||' '||VSK.OB_CSSM_VOY_NO " ).append("\n"); 
		query.append("		     from mdm_vsl_cntr vsl, bkg_vvd vvd, VSK_VSL_PORT_SKD VSK " ).append("\n"); 
		query.append("		    where vsl.vsl_cd         = vvd.vsl_cd" ).append("\n"); 
		query.append("		      and vvd.vsl_pre_pst_cd = 'S'" ).append("\n"); 
		query.append("		      and vvd.vsl_seq        = '1'" ).append("\n"); 
		query.append("		      and vvd.bkg_no         = bk.bkg_no" ).append("\n"); 
		query.append("			  AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("              AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("              AND ROWNUM =1 " ).append("\n"); 
		query.append("			) pre_vsl_nm      " ).append("\n"); 
		query.append("		, bk.por_cd" ).append("\n"); 
		query.append("		, SUBSTR((select LOC_NM from mdm_location where loc_cd = bk.por_cd),0,25) por_nm" ).append("\n"); 
		query.append("		, bk.pol_cd" ).append("\n"); 
		query.append("		, SUBSTR((select LOC_NM from mdm_location where loc_cd = bk.pol_cd),0,25) pol_nm" ).append("\n"); 
		query.append("		, bk.pod_cd" ).append("\n"); 
		query.append("		, SUBSTR((select LOC_NM from mdm_location where loc_cd = bk.pod_cd),0,25) pod_nm" ).append("\n"); 
		query.append("		, bk.del_cd" ).append("\n"); 
		query.append("		, SUBSTR(decode(bk.rcv_term_cd, 'Y', nvl(del_nm.attr_ctnt2, del.loc_nm), del.loc_nm),0,25) del_nm" ).append("\n"); 
		query.append("-- NEW DELHI set 추가 Y term인 경우에 한해서	" ).append("\n"); 
		query.append("--		, decode(bk.rcv_term_cd, 'Y', decode(NVL(bk.del_nod_cd, ' '), " ).append("\n"); 
		query.append("--										'INDELY1', 'ICD TUGHLAKABAD,NEW DELHI'," ).append("\n"); 
		query.append("--										'INDELY2', 'ICD PATPARGANJ, NEW DELHI'," ).append("\n"); 
		query.append("--		  								(select LOC_NM from mdm_location where loc_cd = bk.del_cd))," ).append("\n"); 
		query.append("--									(select LOC_NM from mdm_location where loc_cd = bk.del_cd))" ).append("\n"); 
		query.append("		, nvl(@[fnl_dest_nm]," ).append("\n"); 
		query.append("          (select final_nm.attr_ctnt2" ).append("\n"); 
		query.append("		     from bkg_hrd_cdg_ctnt final_nm" ).append("\n"); 
		query.append("		    where bk.pod_cd         = final_nm.attr_ctnt1(+)" ).append("\n"); 
		query.append("		      and 'BL_FINAL_NAME'   = final_nm.hrd_cdg_id(+))) final_nm" ).append("\n"); 
		query.append("		, @[cre_usr_id]" ).append("\n"); 
		query.append("		, sysdate" ).append("\n"); 
		query.append("		, @[upd_usr_id]" ).append("\n"); 
		query.append("		, sysdate" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("		, mdm_location del" ).append("\n"); 
		query.append("		, bkg_hrd_cdg_ctnt del_nm" ).append("\n"); 
		query.append(" where bk.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("   and bk.del_cd        = del.loc_cd	" ).append("\n"); 
		query.append("   and bk.del_cd||SUBSTR(bk.del_nod_cd, 6, 2) = del_nm.attr_ctnt1(+)" ).append("\n"); 
		query.append("   and 'BL_DEL_NAME'            = del_nm.hrd_cdg_id(+)" ).append("\n"); 

	}
}