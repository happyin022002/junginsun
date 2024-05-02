/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301BlMain1
	  * * 2011.07.26  김진승 [CHM-201112463-01] [ALPS] Vessel call ref. in F/F 301(Logistics) 추가 요청; SQL 처리
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ns_brac",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ec_edircv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_old_rel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL").append("\n"); 
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
		query.append("SELECT 'BKGNBR:'					|| BB.BKG_NO                   								|| CHR(10)" ).append("\n"); 
		query.append("				|| 'BKG_DT:'		|| TO_CHAR(BB.BKG_CRE_DT, 'RRRRMMDDHH24MISS')				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'BRAC:'          || DECODE(BB.BKG_STS_CD, 'X', 'R', " ).append("\n"); 
		query.append("				   NVL(@[brac_cd], NVL((SELECT CASE WHEN TML_NTC_SND_STS_CD = 'R' THEN 'N'" ).append("\n"); 
		query.append("									   		        ELSE 'U' END BRAC" ).append("\n"); 
		query.append("										  FROM (SELECT TML_NTC_SND_STS_CD, MAX(HIS_SEQ) HIS_SEQ--마지막 전송 기록" ).append("\n"); 
		query.append("										          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("										       	 WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("										           AND NTC_VIA_CD  = 'E'" ).append("\n"); 
		query.append("												   AND EDI_ID      = @[rcv_id]" ).append("\n"); 
		query.append("												   AND TML_NTC_SND_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("												 GROUP BY TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append("												 ORDER BY HIS_SEQ DESC)" ).append("\n"); 
		query.append("										 WHERE rownum = 1), 'N')))              									|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NS_BRAC:'		|| @[ns_brac] || CHR(10)" ).append("\n"); 
		query.append("				|| 'BL_NO:'			|| NVL(BB.BL_NO,' ')||DECODE(NVL(BB.BL_TP_CD,' '),'S',' ',NVL(BB.BL_TP_CD,' ')) || CHR(10)" ).append("\n"); 
		query.append("				|| 'BKG_LANE:'		|| DECODE(LENGTH(BB.SLAN_CD),   3, DECODE(SUBSTR(BB.SLAN_CD,1,1),   CHR('0'), null, BB.SLAN_CD),   null) || CHR(10)" ).append("\n"); 
		query.append("				|| 'BV_LANE:'		|| DECODE(LENGTH(VVD1.SLAN_CD), 3, DECODE(SUBSTR(VVD1.SLAN_CD,1,1), CHR('0'), null, VVD1.SLAN_CD), null) || CHR(10)" ).append("\n"); 
		query.append("				|| 'TOVSL:'			|| VVD1.VSL_CD								|| CHR(10)" ).append("\n"); 
		query.append("				|| 'LOYD:'			|| MVC1.LLOYD_NO							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'VSLNAME:'		|| MVC1.VSL_ENG_NM							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'VSL_CALL_SIGN:'	|| MVC1.CALL_SGN_NO							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'VVD_REF_NO:'	|| case when bb.pol_cd = 'MYPKG' or bb.pol_cd = 'PTLEI' then " ).append("\n"); 
		query.append("																		(  select CVY_REF_NO " ).append("\n"); 
		query.append("																		     from bkg_vsl_dchg_yd dchg" ).append("\n"); 
		query.append("																			where dchg.vsl_cd     = VVPS1.vsl_cd" ).append("\n"); 
		query.append("																			  and dchg.skd_voy_no = VVPS1.skd_voy_no" ).append("\n"); 
		query.append("																			  and dchg.skd_dir_cd = VVPS1.skd_dir_cd" ).append("\n"); 
		query.append("																			  and dchg.port_cd      = VVPS1.vps_port_cd" ).append("\n"); 
		query.append("																			  and dchg.clpt_ind_seq = VVPS1.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("											else (  select UQ_VSL_ID_NO" ).append("\n"); 
		query.append("													from bkg_vsl_dchg_yd dchg" ).append("\n"); 
		query.append("													where dchg.vsl_cd     = VVPS1.vsl_cd" ).append("\n"); 
		query.append("													and dchg.skd_voy_no = VVPS1.skd_voy_no" ).append("\n"); 
		query.append("													and dchg.skd_dir_cd = VVPS1.skd_dir_cd" ).append("\n"); 
		query.append("													and dchg.port_cd      = VVPS1.vps_port_cd" ).append("\n"); 
		query.append("													and dchg.clpt_ind_seq = VVPS1.CLPT_IND_SEQ) end " ).append("\n"); 
		query.append("																							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TOVOY:'			|| VVD1.SKD_VOY_NO										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TODIR:'			|| VVD1.SKD_DIR_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'VSLLD:'			|| TO_CHAR(VVPS1.VPS_ETD_DT, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("				|| 'VSLD:'			|| TO_CHAR(VVPS2.VPS_ETA_DT, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("#if(${vsl_cd} != '')" ).append("\n"); 
		query.append("				|| 'OLDVSL:'			|| DECODE(@[brac], 'B', NVL(@[vsl_cd], '    '),		   'R', NVL(@[vsl_cd], '    '), '    ')		|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDLOYD:'			|| DECODE(@[brac], 'B', NVL(OLD_T_VVD.LLOYD_NO, ''),   'R', NVL(OLD_T_VVD.LLOYD_NO, ''), '')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVSLNAME:'		|| DECODE(@[brac], 'B', NVL(OLD_T_VVD.VSL_ENG_NM, ''), 'R', NVL(OLD_T_VVD.VSL_ENG_NM, ''), '')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVSL_CALL_SIGN:'	|| DECODE(@[brac], 'B', NVL(OLD_T_VVD.CALL_SGN_NO, ''),'R', NVL(OLD_T_VVD.CALL_SGN_NO, ''), '')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVOY:'			|| DECODE(@[brac], 'B', NVL(@[skd_voy_no], '    '),	   'R', NVL(@[skd_voy_no], '    '), '    ')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDDIR:'			|| DECODE(@[brac], 'B', NVL(@[skd_dir_cd], ' '),	   'R', NVL(@[skd_dir_cd], ' '), ' ')		|| CHR(10)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				|| 'OLDVSL:    '		|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDLOYD:'			|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVSLNAME:'		|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVSL_CALL_SIGN:'	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDVOY:    '		|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDDIR: '			|| CHR(10)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				|| 'TVSL:'			|| BB.VSL_CD							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TLOYD:'			|| MVCT.LLOYD_NO						|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TVSLNAME:'		|| MVCT.VSL_ENG_NM						|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TVSL_CALL_SIGN:'	|| MVCT.CALL_SGN_NO					|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TVSLOPR:'		|| MVCT.CRR_CD							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TVOY:'			|| BB.SKD_VOY_NO						|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TDIR:'			|| BB.SKD_DIR_CD						|| CHR(10)" ).append("\n"); 
		query.append("				|| DECODE((SELECT DECODE(COUNT(1), 0, 'N', 'Y')" ).append("\n"); 
		query.append("  							FROM BKG_EDI_TRD_PRNR_SUB_LNK A" ).append("\n"); 
		query.append("     							 ,BKG_EDI_SUB_LNK_MSG B" ).append("\n"); 
		query.append(" 						   WHERE PRNR_PORT_CD LIKE 'MY%'" ).append("\n"); 
		query.append("                             AND A.TRD_PRNR_SUB_LNK_SEQ = B.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                             AND B.EDI_MSG_IND_CD = 2" ).append("\n"); 
		query.append("                             AND B.MSG_TP_DESC = 1" ).append("\n"); 
		query.append("                             AND A.EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append("                             AND A.RCVR_TRD_PRNR_ID = @[ec_edircv_id]),'Y','REF_VVD:'||NVL(BB.MY_FWRD_VSL_DESC,' ')	|| CHR(10), '')" ).append("\n"); 
		query.append("				|| 'POR_NAME:'		|| POR.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POR_AMSQUAL:'	|| DECODE(LENGTH(POR.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POR_AMSPORT:'	|| POR.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POR_UNLC:'		|| POR.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POR_YDCD:'		|| BB.POR_NOD_CD          								    || CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_NAME:'		|| POL.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_AMSQUAL:'	|| DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_AMSPORT:'	|| POL.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_UNLC:'		|| POL.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_YDCD:'		|| BB.POL_NOD_CD								            || CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_ETA:'		|| TO_CHAR(VVPS1.VPS_ETA_DT, 'RRRRMMDDHH24MI')				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_ETD:'		|| TO_CHAR(VVPS1.VPS_ETD_DT, 'RRRRMMDDHH24MI')				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_ETD_7:'		|| TO_CHAR(VVPS1.VPS_ETD_DT + 7, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("				|| 'BED:'			|| DECODE(VVPS1.VSL_CD," ).append("\n"); 
		query.append("								'HJXX',TO_CHAR(ADD_MONTHS(BB.BKG_CRE_DT,1),'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("								TO_CHAR(ADD_MONTHS(VVPS1.VPS_ETD_DT,1),'YYYYMMDDHH24MI'))		|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POL_CCT:'		|| NVL(TO_CHAR(CLZ.MNL_SET_DT, 'yyyymmddhh24mi')," ).append("\n"); 
		query.append("								NVL(TO_CHAR(CLZ.SYS_SET_DT, 'yyyymmddhh24mi'),'')) 				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_NAME:'		|| POD.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_AMSQUAL:'	|| DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_AMSPORT:'	|| POD.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_UNLC:'		|| POD.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_YDCD:'		|| BB.POD_NOD_CD											|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_ETA:'		|| TO_CHAR(VVPS2.VPS_ETA_DT, 'RRRRMMDDHH24MI')				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'POD_ETD:'		|| TO_CHAR(VVPS2.VPS_ETD_DT, 'RRRRMMDDHH24MI')				|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_NAME:'		|| DEL.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_AMSQUAL:'	|| DECODE(LENGTH(DEL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_AMSPORT:'	|| DEL.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_UNLC:'		|| DEL.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_YDCD:'		|| BB.DEL_NOD_CD									        || CHR(10)" ).append("\n"); 
		query.append("				|| 'PLD_ETA:'																	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'RLY_NAME:'		|| POST.LOC_NM											    || CHR(10)" ).append("\n"); 
		query.append("				|| 'RLY_AMSQUAL:'	|| DECODE(LENGTH(POST.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')|| CHR(10)" ).append("\n"); 
		query.append("				|| 'RLY_AMSPORT:'	|| POST.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("				|| 'RLY_UNLC:'		|| POST.LOC_CD												|| CHR(10)" ).append("\n"); 
		query.append("                || 'RLY_YDCD:'		|| (SELECT BV.POL_YD_CD FROM BKG_VVD BV WHERE BV.BKG_NO = BB.BKG_NO AND BV.POL_CD = BB.PST_RLY_PORT_CD AND BV.VSL_PRE_PST_CD = 'U' AND BV.VSL_SEQ = 1 AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("				|| 'HUB_UNLC:'		|| NVL(HUB.HUB_LOC_CD,' ')									|| CHR(10)--mds				" ).append("\n"); 
		query.append("				|| 'HUB_NAME:'		|| NVL(HUBNM.LOC_NM,' ')									|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PUNIT:'			|| BBD.PCK_TP_CD											|| CHR(10)" ).append("\n"); 
		query.append("				|| 'PKG:'			|| BBD.PCK_QTY												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'WUNIT:'			|| SUBSTR(BBD.WGT_UT_CD, 1, 1)							    || CHR(10)" ).append("\n"); 
		query.append("				|| 'WGT:'			|| BBD.ACT_WGT										        || CHR(10)" ).append("\n"); 
		query.append("				|| 'EWUNIT:'		|| SUBSTR(BBD.WGT_UT_CD, 1, 1)							    || CHR(10)" ).append("\n"); 
		query.append("				|| 'EWGT:'			|| BBD.ACT_WGT										        || CHR(10)" ).append("\n"); 
		query.append("				|| 'MUNIT:'			|| SUBSTR(BBD.MEAS_UT_CD, 3, 1)								|| CHR(10)" ).append("\n"); 
		query.append("				|| 'MEAS:'			|| BBD.MEAS_QTY												|| CHR(10)" ).append("\n"); 
		query.append("				|| 'RDTYP:'			|| BB.RCV_TERM_CD || BB.DE_TERM_CD							|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SMOD:'			|| BB.DEST_TRNS_SVC_MOD_CD									|| CHR(10)" ).append("\n"); 
		query.append("				|| 'TRUCK:'			 															|| CHR(10)" ).append("\n"); 
		query.append("				|| 'REMARK:'		|| REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(BB.XTER_RMK, CHR(13)||CHR(10),' '), CHR(10), ' '), CHR(13), ' '), '*', '-'), ':', '-'), '~', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CMD:'			|| NVL(MCMDT.cmdt_cd, MRCMDT.REP_CMDT_CD)					|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CMDD:'			|| NVL(MCMDT.CMDT_NM, MRCMDT.REP_CMDT_NM)					|| CHR(10)" ).append("\n"); 
		query.append("				|| 'EQREL:'			|| BB.MTY_PKUP_YD_CD                      					|| CHR(10)" ).append("\n"); 
		query.append("				|| 'OLDEQREL:'		|| DECODE(@[edi_old_rel],BB.MTY_PKUP_YD_CD,'',@[edi_old_rel])|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SCNO:'          || BB.SC_NO     											|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHN1:'			|| REPLACE(REPLACE(REPLACE(SH.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'FFN1:'			|| REPLACE(REPLACE(REPLACE(FW.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNE1:'			|| REPLACE(REPLACE(REPLACE(CN.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SH_CD1:'		|| SH.CUST_CNT_CD||DECODE(SH.CUST_SEQ,'0', null, SH.CUST_SEQ)   || CHR(10)" ).append("\n"); 
		query.append("				|| 'FF_CD1:'		|| FW.CUST_CNT_CD||DECODE(FW.CUST_SEQ,'0', null, FW.CUST_SEQ)	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CN_CD1:'		|| CN.CUST_CNT_CD||DECODE(CN.CUST_SEQ,'0', null, CN.CUST_SEQ)	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR1:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(SH.CUST_NM, 1), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR2:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(SH.CUST_NM, 2), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR3:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 1), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR4:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 2), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR5:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 3), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR_CITY:'		|| SH.CUST_CTY_NM															|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR_STATE:'	|| SH.CUST_STE_CD															|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR_COUNTRY:'	|| SH.CSTMS_DECL_CNT_CD														|| CHR(10)" ).append("\n"); 
		query.append("				|| 'SHPR_ZIP:'		|| SH.CUST_ZIP_ID															|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNEE1:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(CN.CUST_NM, 1), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNEE2:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(CN.CUST_NM, 2), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNEE3:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(CN.CUST_ADDR, 1), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNEE4:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(CN.CUST_ADDR, 2), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'CNEE5:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(CN.CUST_ADDR, 3), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NTFY1:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(FW.CUST_NM, 1), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NTFY2:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(FW.CUST_NM, 2), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NTFY3:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(FW.CUST_NM, 3), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NTFY4:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(FW.CUST_NM, 4), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'NTFY5:'			|| REPLACE(REPLACE(SCE_TOKEN_NL_FNC(FW.CUST_NM, 5), '*', '-'), ':', '-')	|| CHR(10)" ).append("\n"); 
		query.append("				|| 'FWD_REF_CD:'	|| BB.MY_FWRD_CD															|| CHR(10)" ).append("\n"); 
		query.append("				|| 'FWD_REF_DESC:'	|| REPLACE(BMF.MY_FWRD_NM, CHR(13)||CHR(10), '')							|| CHR(10) BL_MAIN1" ).append("\n"); 
		query.append("			FROM	BKG_BOOKING	BB, BKG_VVD VVD1, BKG_VVD VVD2, MDM_VSL_CNTR MVC1, MDM_VSL_CNTR MVCT," ).append("\n"); 
		query.append("				    VSK_VSL_PORT_SKD VVPS1, VSK_VSL_PORT_SKD VVPS2, MDM_COMMODITY MCMDT, MDM_REP_CMDT MRCMDT," ).append("\n"); 
		query.append("					BKG_CUSTOMER SH, BKG_CUSTOMER CN, BKG_CUSTOMER FW," ).append("\n"); 
		query.append("					MDM_LOCATION POL, MDM_LOCATION POD, MDM_LOCATION POR, MDM_LOCATION DEL, MDM_LOCATION POST," ).append("\n"); 
		query.append("					BKG_BL_DOC BBD, BKG_MY_FWRD BMF, BKG_CLZ_TM CLZ, PRD_HUB_LOC_MTCH HUB, MDM_LOCATION HUBNM --mds" ).append("\n"); 
		query.append("#if(${vsl_cd} != '')" ).append("\n"); 
		query.append("					, MDM_VSL_CNTR OLD_T_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			WHERE	BB.BKG_NO		    = @[bkg_no]" ).append("\n"); 
		query.append("			AND		BB.POL_CD		    = POL.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		BB.POD_CD		    = POD.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		BB.POR_CD		    = POR.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		BB.DEL_CD		    = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		BB.PST_RLY_PORT_CD  = POST.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		BB.CMDT_CD		    = MCMDT.CMDT_CD(+)" ).append("\n"); 
		query.append("			AND		BB.REP_CMDT_CD	    = MRCMDT.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		    = BBD.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		    = SH.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		SH.BKG_CUST_TP_CD(+)= 'S'" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		    = CN.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		CN.BKG_CUST_TP_CD(+)= 'C'" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		    = FW.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		FW.BKG_CUST_TP_CD(+)= 'F'" ).append("\n"); 
		query.append("#if(${vsl_cd} != '')" ).append("\n"); 
		query.append("			AND		OLD_T_VVD.VSL_CD    (+)= @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		    = VVD1.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		BB.POL_CD		    = VVD1.POL_CD(+)" ).append("\n"); 
		query.append("			AND		VVD1.VSL_CD		    = VVPS1.VSL_CD(+)" ).append("\n"); 
		query.append("			AND		VVD1.SKD_VOY_NO	    = VVPS1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("			AND		VVD1.SKD_DIR_CD		= VVPS1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("			AND		VVD1.POL_CD 		= VVPS1.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("			AND		VVD1.POL_CLPT_IND_SEQ = VVPS1.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("			AND		VVD1.VSL_CD		     = MVC1.VSL_CD(+)" ).append("\n"); 
		query.append("			AND		BB.VSL_CD		     = MVCT.VSL_CD(+)" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		     = VVD2.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		BB.POD_CD		     = VVD2.POD_CD(+)" ).append("\n"); 
		query.append("			AND		VVD2.VSL_CD		     = VVPS2.VSL_CD(+)" ).append("\n"); 
		query.append("			AND		VVD2.SKD_VOY_NO	     = VVPS2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("			AND		VVD2.SKD_DIR_CD		 = VVPS2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("			AND		VVD2.POD_CD   		 = VVPS2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("			AND		VVD2.POL_CLPT_IND_SEQ = VVPS2.CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append("			AND		BB.MY_FWRD_CD        = BMF.MY_FWRD_CD(+)" ).append("\n"); 
		query.append("			AND		BB.BKG_NO		     = CLZ.BKG_NO(+)" ).append("\n"); 
		query.append("			AND		CLZ.CLZ_TP_CD(+)     = 'T'" ).append("\n"); 
		query.append("			AND		BB.POD_CD   		 = HUB.PORT_CD(+) --mds                       " ).append("\n"); 
		query.append("			AND		BB.DEL_CD   		 = HUB.LOC_CD(+)" ).append("\n"); 
		query.append("			AND		HUB.HUB_LOC_CD   	 = HUBNM.LOC_CD(+)" ).append("\n"); 

	}
}