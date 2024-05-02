/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Checking Report 화면의 Port Restrictions En-route 목록을 가져온다.
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL").append("\n"); 
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
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("##설명" ).append("\n"); 
		query.append("##1. WITH UN_NO_TBL : 컨테이너별 Un No. 의 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##2. PORT_RSTR_TBL1 : 1번에 대하여 Un No. 별  Port제한사항을 적용하여 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##3. PORT_RSTR_TBL2 : 1번에 대하여 Class 별 Port제한사항을 적용하여 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##4. VSL_RSTR_TBL1  : 1번에 대하여 Un No. 별  Vessel제한사항을 적용하여 임시 테이블을 생성한다. -by 이도형(2009.12.28)" ).append("\n"); 
		query.append("##5. BKG_VVD_TBL    : Port에 대한 Vessel 스케쥴 정보에서 자사(Booking)/타사(POL,POD)의 POL/POD 구간을 추출하여 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##6. ROUTE_TBL      : 4번에 대한 전체 Route를 구성한 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##7. <Main Query>   : 전체 Route에 대한 POL,POD,T/S,Pass,Skip Port를 기본적으로 구성한 후 컨테이너별 Un No.에 대한 Prohibition여부 정보 목록을 생성한다." ).append("\n"); 
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("WITH UN_NO_TBL AS ( " ).append("\n"); 
		query.append("##     SELECT TUN.IMDG_UN_NO " ).append("\n"); 
		query.append("##          , TUN.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("##          , TUN.IMDG_CLSS_CD " ).append("\n"); 
		query.append("##       FROM ( " ).append("\n"); 
		query.append("##             SELECT UN.IMDG_UN_NO " ).append("\n"); 
		query.append("##                  , UN.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("##                  , UN.IMDG_CLSS_CD " ).append("\n"); 
		query.append("##               FROM SCG_IMDG_UN_NO UN " ).append("\n"); 
		query.append("##              WHERE 1=1 " ).append("\n"); 
		query.append("##                AND ( " ).append("\n"); 
		query.append("###foreach(${obj} in ${opt_obj}) " ).append("\n"); 
		query.append("##                   (UN.IMDG_CLSS_CD   = '$obj.getImdgClssCd()' " ).append("\n"); 
		query.append("##                AND UN.IMDG_UN_NO     = '$obj.getImdgUnNo()' " ).append("\n"); 
		query.append("##                AND UN.IMDG_UN_NO_SEQ = '$obj.getImdgUnNoSeq()') " ).append("\n"); 
		query.append("##     #if($velocityCount < ${obj_size}) " ).append("\n"); 
		query.append("##                 OR " ).append("\n"); 
		query.append("##     #end " ).append("\n"); 
		query.append("###end " ).append("\n"); 
		query.append("##                    ) " ).append("\n"); 
		query.append("##             ) TUN " ).append("\n"); 
		query.append("##      GROUP BY " ).append("\n"); 
		query.append("##            TUN.IMDG_UN_NO " ).append("\n"); 
		query.append("##          , TUN.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("##          , TUN.IMDG_CLSS_CD " ).append("\n"); 
		query.append("#foreach(${obj} in ${opt_obj}) " ).append("\n"); 
		query.append("		SELECT '$obj.getSpclCntrSeq()' AS SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("		     , '$obj.getSpclCgoSeq()'  AS SPCL_CGO_SEQ " ).append("\n"); 
		query.append("		     , '$obj.getImdgUnNo()'    AS IMDG_UN_NO " ).append("\n"); 
		query.append("		     , '$obj.getImdgUnNoSeq()' AS IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("		     , '$obj.getImdgClssCd()'  AS IMDG_CLSS_CD " ).append("\n"); 
		query.append("		  FROM DUAL " ).append("\n"); 
		query.append("		#if($velocityCount < ${obj_size}) " ).append("\n"); 
		query.append("		UNION ALL " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",VSL_RSTR_TBL1 AS (" ).append("\n"); 
		query.append("		SELECT 'N' PROHI_LOD_FLG" ).append("\n"); 
		query.append("    		 , 'N' PROHI_DCHG_FLG" ).append("\n"); 
		query.append("		     , 'Y' PROHI_TS_FLG" ).append("\n"); 
		query.append("		     , 'N' PROHI_PASS_FLG" ).append("\n"); 
		query.append("		     , 'T' PORT_TYPE" ).append("\n"); 
		query.append("		     , UT.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("		     , UT.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("			 , UT.IMDG_UN_NO" ).append("\n"); 
		query.append("		     , UT.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("			 , UT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		     , VR.IMDG_CRR_RSTR_SEQ" ).append("\n"); 
		query.append("	     FROM  UN_NO_TBL          UT" ).append("\n"); 
		query.append("    		 , SCG_IMDG_CRR_RSTR VR" ).append("\n"); 
		query.append("    	WHERE UT.IMDG_UN_NO     = VR.IMDG_UN_NO" ).append("\n"); 
		query.append("      	  AND UT.IMDG_UN_NO_SEQ = VR.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    	  AND UT.IMDG_CLSS_CD   = VR.IMDG_CLSS_CD" ).append("\n"); 
		query.append("	      AND VR.IMDG_CRR_RSTR_EXPT_CD = 'T'" ).append("\n"); 
		query.append("    	  AND VR.VSL_OPR_TP_CD = 'SML'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",BKG_VVD_TBL AS " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("     , BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("     , BV.VSL_SEQ" ).append("\n"); 
		query.append("     , BV.SLAN_CD" ).append("\n"); 
		query.append("     , BV.VSL_CD" ).append("\n"); 
		query.append("     , BV.SKD_VOY_NO" ).append("\n"); 
		query.append("     , BV.SKD_DIR_CD" ).append("\n"); 
		query.append("     , BV.POL_CD" ).append("\n"); 
		query.append("     , BV.POD_CD" ).append("\n"); 
		query.append("     , VP1.CLPT_SEQ POL_SEQ" ).append("\n"); 
		query.append("     , VP2.CLPT_SEQ POD_SEQ    " ).append("\n"); 
		query.append("  FROM BKG_VVD          BV" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD VP1" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD VP2" ).append("\n"); 
		query.append(" WHERE BV.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("   AND BV.VSL_CD           = VP1.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO       = VP1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD       = VP1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BV.SLAN_CD          = VP1.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND BV.POL_CD           = VP1.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND BV.POL_CLPT_IND_SEQ = VP1.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND BV.VSL_CD           = VP2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO       = VP2.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD       = VP2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BV.SLAN_CD          = VP2.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND BV.POD_CD           = VP2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND BV.POD_CLPT_IND_SEQ = VP2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '' BKG_NO" ).append("\n"); 
		query.append("     , 'T' VSL_PRE_PST_CD" ).append("\n"); 
		query.append("     , 0 VSL_SEQ" ).append("\n"); 
		query.append("     , VP.SLAN_CD" ).append("\n"); 
		query.append("     , VP.VSL_CD" ).append("\n"); 
		query.append("     , VP.SKD_VOY_NO" ).append("\n"); 
		query.append("     , VP.SKD_DIR_CD" ).append("\n"); 
		query.append("     , MAX(DECODE(VP.VPS_PORT_CD||VP.CLPT_IND_SEQ,@[pol_cd],VP.VPS_PORT_CD,'')) POL_CD " ).append("\n"); 
		query.append("     , MAX(DECODE(VP.VPS_PORT_CD||VP.CLPT_IND_SEQ,@[pod_cd],VP.VPS_PORT_CD,'')) POD_CD " ).append("\n"); 
		query.append("     , SUM(DECODE(VP.VPS_PORT_CD||VP.CLPT_IND_SEQ,@[pol_cd],VP.CLPT_SEQ, 0))    POL_SEQ" ).append("\n"); 
		query.append("     , SUM(DECODE(VP.VPS_PORT_CD||VP.CLPT_IND_SEQ,@[pod_cd],VP.CLPT_SEQ, 0))    POD_SEQ" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append(" WHERE VP.VPS_PORT_CD||VP.CLPT_IND_SEQ IN(@[pol_cd],@[pod_cd])" ).append("\n"); 
		query.append("   AND VP.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VP.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VP.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VP.SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       VP.SLAN_CD" ).append("\n"); 
		query.append("     , VP.VSL_CD" ).append("\n"); 
		query.append("     , VP.SKD_VOY_NO" ).append("\n"); 
		query.append("     , VP.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",ROUTE_TBL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TVP2.PORT_CD" ).append("\n"); 
		query.append("     , TVP2.ORDER_NUM1 ORDER_NUM1" ).append("\n"); 
		query.append("     , TVP2.ORDER_NUM2 ORDER_NUM2" ).append("\n"); 
		query.append("     , DECODE(TVP2.SKD_CNG_STS_CD,'S','S', DECODE(TVP2.POL_SEQ,1,'L',DECODE(TVP2.POD_SEQ,1,'D',DECODE(TVP2.PORT_CD,TVP2.POD_CD,'T','P')))) PORT_TYPE" ).append("\n"); 
		query.append("     , TVP2.VVD_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT TVP1.PORT_CD" ).append("\n"); 
		query.append("           , TVP1.POD_CD" ).append("\n"); 
		query.append("           , TVP1.ORDER_NUM1" ).append("\n"); 
		query.append("           , TVP1.ORDER_NUM2" ).append("\n"); 
		query.append("           , TVP1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("           , RANK() OVER(ORDER BY TVP1.ORDER_NUM1, TVP1.ORDER_NUM2)                              POL_SEQ" ).append("\n"); 
		query.append("           , DENSE_RANK() OVER(ORDER BY TVP1.ORDER_NUM1 DESC, TVP1.ORDER_NUM2 DESC)              POD_SEQ" ).append("\n"); 
		query.append("	       , ROW_NUMBER() OVER(PARTITION BY TVP1.PORT_CD, TVP1.CLPT_IND_SEQ ORDER BY TVP1.PORT_CD, TVP1.ORDER_NUM1) TS_DUP_NUM" ).append("\n"); 
		query.append("           , TVP1.VVD_CD" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT VPS.VPS_PORT_CD                              AS PORT_CD" ).append("\n"); 
		query.append("                 , VT1.POD_CD                 " ).append("\n"); 
		query.append("                 , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ              AS ORDER_NUM1" ).append("\n"); 
		query.append("                 , VPS.CLPT_SEQ                                 AS ORDER_NUM2" ).append("\n"); 
		query.append("                 , VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 , NVL(SKD_CNG_STS_CD,'')                       AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                 , (VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD) AS VVD_CD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                 , BKG_VVD_TBL      VT1" ).append("\n"); 
		query.append("             WHERE VPS.VSL_CD     = VT1.VSL_CD" ).append("\n"); 
		query.append("               AND VPS.SKD_VOY_NO = VT1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VPS.SKD_DIR_CD = VT1.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VPS.SLAN_CD    = VT1.SLAN_CD" ).append("\n"); 
		query.append("               AND VPS.CLPT_SEQ  >= VT1.POL_SEQ" ).append("\n"); 
		query.append("               AND VPS.CLPT_SEQ  <= VT1.POD_SEQ       " ).append("\n"); 
		query.append("             GROUP BY VPS.VPS_PORT_CD  " ).append("\n"); 
		query.append("                    , VT1.POD_CD     " ).append("\n"); 
		query.append("                    , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ      " ).append("\n"); 
		query.append("                    , VPS.CLPT_SEQ     " ).append("\n"); 
		query.append("                    , VPS.CLPT_IND_SEQ       " ).append("\n"); 
		query.append("                    , NVL(SKD_CNG_STS_CD,'')" ).append("\n"); 
		query.append("                    , (VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD)" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT VPS.VPS_PORT_CD                 AS PORT_CD" ).append("\n"); 
		query.append("                  , VT1.POD_CD                 " ).append("\n"); 
		query.append("                  , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ AS ORDER_NUM1 " ).append("\n"); 
		query.append("                  , 1                               AS ORDER_NUM2" ).append("\n"); 
		query.append("                  , '1'                             AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  , 'X'                             AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                  , ''                              AS VVD_CD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                 , BKG_VVD_TBL      VT1   " ).append("\n"); 
		query.append("             WHERE VT1.VSL_CD IS NULL" ).append("\n"); 
		query.append("               AND (VPS.VPS_PORT_CD = VT1.POL_CD" ).append("\n"); 
		query.append("                OR VPS.VPS_PORT_CD = VT1.POD_CD)   " ).append("\n"); 
		query.append("             GROUP BY" ).append("\n"); 
		query.append("                   VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("                 , VT1.POD_CD                 " ).append("\n"); 
		query.append("                 , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ" ).append("\n"); 
		query.append("             ) TVP1" ).append("\n"); 
		query.append("       ) TVP2" ).append("\n"); 
		query.append(" WHERE TVP2.TS_DUP_NUM = 1" ).append("\n"); 
		query.append(" ORDER BY TVP2.ORDER_NUM1, TVP2.ORDER_NUM2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",PORT_RSTR_TBL2 AS ( " ).append("\n"); 
		query.append("		SELECT CC.PROHI_LOD_FLG " ).append("\n"); 
		query.append("    		 , CC.PROHI_DCHG_FLG " ).append("\n"); 
		query.append("             , CC.PROHI_TS_FLG" ).append("\n"); 
		query.append("    		 , CC.PROHI_PASS_FLG " ).append("\n"); 
		query.append("    		 , CC.PORT_CD " ).append("\n"); 
		query.append("    		 , UT.SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("    		 , UT.SPCL_CGO_SEQ " ).append("\n"); 
		query.append("    		 , UT.IMDG_UN_NO " ).append("\n"); 
		query.append("    		 , UT.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("    		 , CC.IMDG_CLSS_CD " ).append("\n"); 
		query.append("    		 , CC.IMDG_PORT_RSTR_SEQ " ).append("\n"); 
		query.append("		  FROM UN_NO_TBL          UT" ).append("\n"); 
		query.append("			 , ROUTE_TBL	RT " ).append("\n"); 
		query.append("		     , SCG_IMDG_PORT_RSTR CC " ).append("\n"); 
		query.append("		 WHERE UT.IMDG_CLSS_CD   = CC.IMDG_CLSS_CD " ).append("\n"); 
		query.append("		   AND CC.IMDG_UN_NO     IS NULL " ).append("\n"); 
		query.append("		   AND CC.IMDG_UN_NO_SEQ IS NULL " ).append("\n"); 
		query.append("		   AND RT.PORT_CD   	 = CC.PORT_CD(+)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("PORT_RSTR_TBL1 AS ( " ).append("\n"); 
		query.append("		SELECT RR.PROHI_LOD_FLG " ).append("\n"); 
		query.append("      	     , RR.PROHI_DCHG_FLG " ).append("\n"); 
		query.append("             , RR.PROHI_TS_FLG" ).append("\n"); 
		query.append("      	     , RR.PROHI_PASS_FLG " ).append("\n"); 
		query.append("      	     , RR.PORT_CD " ).append("\n"); 
		query.append("	    	 , UT.SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("		     , UT.SPCL_CGO_SEQ " ).append("\n"); 
		query.append("		     , UT.IMDG_UN_NO " ).append("\n"); 
		query.append("		     , UT.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("		     , UT.IMDG_CLSS_CD " ).append("\n"); 
		query.append("		     , RR.IMDG_PORT_RSTR_SEQ " ).append("\n"); 
		query.append("             , 'U' AS R_TYPE" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("                  FROM SCG_IMDG_PORT_RSTR INC" ).append("\n"); 
		query.append("                 WHERE INC.IMDG_CLSS_CD   = RR.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                   AND INC.PORT_CD        = RR.PORT_CD" ).append("\n"); 
		query.append("                   AND INC.IMDG_UN_NO     IS NULL" ).append("\n"); 
		query.append("                   AND INC.IMDG_UN_NO_SEQ IS NULL" ).append("\n"); 
		query.append("               ) C_TYPE" ).append("\n"); 
		query.append("		  FROM UN_NO_TBL          UT" ).append("\n"); 
		query.append("			 , ROUTE_TBL	RT  " ).append("\n"); 
		query.append("		     , SCG_IMDG_PORT_RSTR RR " ).append("\n"); 
		query.append("		 WHERE UT.IMDG_UN_NO     = RR.IMDG_UN_NO " ).append("\n"); 
		query.append("		   AND UT.IMDG_UN_NO_SEQ = RR.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("		   AND UT.IMDG_CLSS_CD   = RR.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		   AND RT.PORT_CD   	 = RR.PORT_CD(+)  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RT2.PROHI_LOD_FLG " ).append("\n"); 
		query.append("      	     , RT2.PROHI_DCHG_FLG " ).append("\n"); 
		query.append("             , RT2.PROHI_TS_FLG" ).append("\n"); 
		query.append("      	     , RT2.PROHI_PASS_FLG " ).append("\n"); 
		query.append("      	     , RT2.PORT_CD " ).append("\n"); 
		query.append("	    	 , RT2.SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("		     , RT2.SPCL_CGO_SEQ " ).append("\n"); 
		query.append("		     , RT2.IMDG_UN_NO " ).append("\n"); 
		query.append("		     , RT2.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("		     , RT2.IMDG_CLSS_CD " ).append("\n"); 
		query.append("		     , RT2.IMDG_PORT_RSTR_SEQ " ).append("\n"); 
		query.append("             , 'C' AS R_TYPE" ).append("\n"); 
		query.append("             , 'Y' AS C_TYPE" ).append("\n"); 
		query.append("          FROM PORT_RSTR_TBL2 RT2" ).append("\n"); 
		query.append("			   , ROUTE_TBL  RT " ).append("\n"); 
		query.append("         WHERE (RT2.IMDG_UN_NO,RT2.IMDG_UN_NO_SEQ,RT2.IMDG_CLSS_CD,RT2.PORT_CD) NOT IN(" ).append("\n"); 
		query.append("                SELECT EXR.IMDG_UN_NO, EXR.IMDG_UN_NO_SEQ, EXR.IMDG_CLSS_CD, EXR.PORT_CD" ).append("\n"); 
		query.append("                  FROM SCG_IMDG_PORT_RSTR EXR" ).append("\n"); 
		query.append("                 WHERE EXR.IMDG_UN_NO     IS NOT NULL" ).append("\n"); 
		query.append("		           AND EXR.IMDG_UN_NO_SEQ IS NOT NULL" ).append("\n"); 
		query.append("		           AND EXR.IMDG_CLSS_CD   IS NOT NULL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("			   AND RT.PORT_CD   = RT2.PORT_CD(+) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT FT.PORT_TYPE" ).append("\n"); 
		query.append("     , FT.PORT_CD" ).append("\n"); 
		query.append("     , FT.IMDG_CMPTN_AUTH_DESC" ).append("\n"); 
		query.append("	 , FT.RESTRICTION_REQ" ).append("\n"); 
		query.append("     , FT.TXT_DESC" ).append("\n"); 
		query.append("     , FT.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("     , FT.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     , FT.IMDG_UN_NO" ).append("\n"); 
		query.append("     , FT.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("     , FT.ORDER_NUM1" ).append("\n"); 
		query.append("     , FT.ORDER_NUM2" ).append("\n"); 
		query.append("     , FT.VVD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TT.PORT_TYPE " ).append("\n"); 
		query.append("     , TT.PORT_CD " ).append("\n"); 
		query.append("	 -- Prohibition/Restriction" ).append("\n"); 
		query.append("	 -- Restriction은 3가지 이나 Permit일때만 UI에 표시" ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_CMPTN_AUTH_DESC,'Permit', 'Restriction',''),TT.IMDG_CMPTN_AUTH_DESC) AS IMDG_CMPTN_AUTH_DESC " ).append("\n"); 
		query.append("     -- No Need/Permit/Declare" ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'No Need',TT.IMDG_CMPTN_AUTH_DESC,'Declare',TT.IMDG_CMPTN_AUTH_DESC,'Permit',TT.IMDG_CMPTN_AUTH_DESC,''),DECODE(TT.IMDG_CMPTN_AUTH_DESC, 'Prohibition', '',TT.IMDG_CMPTN_AUTH_DESC)) AS RESTRICTION_REQ" ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.TXT_DESC,TT.TXT_DESC),TT.TXT_DESC)                         AS TXT_DESC" ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.SPCL_CNTR_SEQ,'Permit',TT.SPCL_CNTR_SEQ,''),TT.SPCL_CNTR_SEQ)               AS SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.SPCL_CGO_SEQ,'Permit',TT.SPCL_CGO_SEQ,''),TT.SPCL_CGO_SEQ)                 AS SPCL_CGO_SEQ " ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_UN_NO,'Permit',TT.IMDG_UN_NO,''),TT.IMDG_UN_NO)                     AS IMDG_UN_NO " ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_UN_NO_SEQ,'Permit',TT.IMDG_UN_NO_SEQ,''),TT.IMDG_UN_NO_SEQ)             AS IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("     , TT.ORDER_NUM1" ).append("\n"); 
		query.append("     , TT.ORDER_NUM2" ).append("\n"); 
		query.append("     , TT.VVD_CD" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("		SELECT ST.PORT_TYPE " ).append("\n"); 
		query.append("    		 , ST.PORT_CD " ).append("\n"); 
		query.append("    		 , ST.IMDG_CMPTN_AUTH_DESC " ).append("\n"); 
		query.append("    		 , ST.TXT_DESC " ).append("\n"); 
		query.append("    		 , ST.SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("    	     , ST.SPCL_CGO_SEQ " ).append("\n"); 
		query.append("    		 , ST.IMDG_UN_NO " ).append("\n"); 
		query.append("    		 , ST.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("    		 , ST.ORDER_NUM1" ).append("\n"); 
		query.append("             , ST.ORDER_NUM2" ).append("\n"); 
		query.append("    		 , ROW_NUMBER() OVER(PARTITION BY ST.PORT_TYPE, ST.PORT_CD ORDER BY ST.ORDER_NUM1, ST.ORDER_NUM2, DECODE(NVL(ST.IMDG_CMPTN_AUTH_DESC,''),'Prohibition',0,'Permit',1,'Declare',2,'No Need',3,'',4)) AS NUM" ).append("\n"); 
		query.append("             , ST.VVD_CD" ).append("\n"); 
		query.append("		  FROM ( " ).append("\n"); 
		query.append("			SELECT DECODE(RT.PORT_TYPE,'S','Skip','L','POL','D','POD','T','T/S','Pass') PORT_TYPE " ).append("\n"); 
		query.append("		         , RT.PORT_CD " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S',''," ).append("\n"); 
		query.append("                          DECODE(                          " ).append("\n"); 
		query.append("                                CASE WHEN R.R_TYPE='C' THEN NULL  " ).append("\n"); 
		query.append("                                     ELSE" ).append("\n"); 
		query.append("                                         CASE WHEN ((R.IMDG_UN_NO=C.IMDG_UN_NO AND R.IMDG_UN_NO_SEQ=C.IMDG_UN_NO_SEQ) OR (R.C_TYPE IS NULL AND (R.IMDG_UN_NO!=C.IMDG_UN_NO OR R.IMDG_UN_NO_SEQ!=C.IMDG_UN_NO_SEQ)) OR C.IMDG_UN_NO IS NULL) THEN   " ).append("\n"); 
		query.append("                                                   CASE WHEN RT.PORT_TYPE='L' THEN" ).append("\n"); 
		query.append("                                                             CASE WHEN R.PROHI_LOD_FLG='Y' THEN 'Prohibition'                                                                  " ).append("\n"); 
		query.append("                                                                  ELSE DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                             END" ).append("\n"); 
		query.append("                                                        WHEN RT.PORT_TYPE='D' THEN" ).append("\n"); 
		query.append("                                                             CASE WHEN R.PROHI_DCHG_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                                  ELSE DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                             END" ).append("\n"); 
		query.append("                                                        WHEN RT.PORT_TYPE='T' THEN" ).append("\n"); 
		query.append("                                                             CASE WHEN R.PROHI_TS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                                  ELSE DECODE(TD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                             END" ).append("\n"); 
		query.append("                                                        WHEN RT.PORT_TYPE='P' THEN" ).append("\n"); 
		query.append("                                                             CASE WHEN R.PROHI_PASS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                                  ELSE DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                             END" ).append("\n"); 
		query.append("                                                        ELSE 'X'" ).append("\n"); 
		query.append("                                                   END" ).append("\n"); 
		query.append("                                              ELSE 'X'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                                ,NULL," ).append("\n"); 
		query.append("                                CASE WHEN (R.IMDG_UN_NO=C.IMDG_UN_NO AND R.IMDG_UN_NO_SEQ=C.IMDG_UN_NO_SEQ AND C.IMDG_UN_NO IS NOT NULL) THEN   " ).append("\n"); 
		query.append("                                          CASE WHEN RT.PORT_TYPE='L' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN C.PROHI_LOD_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(LC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='D' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN C.PROHI_DCHG_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(DC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='T' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN C.PROHI_TS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(TC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='P' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN C.PROHI_PASS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(PC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               ELSE 'X'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                     ELSE 'X'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                                ,'X',''," ).append("\n"); 
		query.append("                                CASE WHEN ((R.IMDG_UN_NO=C.IMDG_UN_NO AND R.IMDG_UN_NO_SEQ=C.IMDG_UN_NO_SEQ) OR (R.C_TYPE IS NULL AND (R.IMDG_UN_NO!=C.IMDG_UN_NO OR R.IMDG_UN_NO_SEQ!=C.IMDG_UN_NO_SEQ)) OR C.IMDG_UN_NO IS NULL) THEN   " ).append("\n"); 
		query.append("                                          CASE WHEN RT.PORT_TYPE='L' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN R.PROHI_LOD_FLG='Y' THEN 'Prohibition'                                                                  " ).append("\n"); 
		query.append("                                                         ELSE DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='D' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN R.PROHI_DCHG_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='T' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN R.PROHI_TS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(TD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               WHEN RT.PORT_TYPE='P' THEN" ).append("\n"); 
		query.append("                                                    CASE WHEN R.PROHI_PASS_FLG='Y' THEN 'Prohibition'" ).append("\n"); 
		query.append("                                                         ELSE DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                               ELSE 'X'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                     ELSE 'X'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                   ) IMDG_CMPTN_AUTH_DESC " ).append("\n"); 
		query.append("				 , DECODE(RT.PORT_TYPE,'S','',DECODE(R.R_TYPE,'U',DECODE(RT.PORT_TYPE,'L',LD.TXT_DESC,'D',DD.TXT_DESC,'T',TD.TXT_DESC,PD.TXT_DESC)" ).append("\n"); 
		query.append("                                                                 ,DECODE(RT.PORT_TYPE,'L',LC.TXT_DESC,'D',DC.TXT_DESC,'T',TC.TXT_DESC,PC.TXT_DESC))) TXT_DESC " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S','',DECODE(R.R_TYPE,'U',R.SPCL_CNTR_SEQ,C.SPCL_CNTR_SEQ))               SPCL_CNTR_SEQ " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S','',DECODE(R.R_TYPE,'U',R.SPCL_CGO_SEQ,C.SPCL_CGO_SEQ))                 SPCL_CGO_SEQ " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S','',DECODE(R.R_TYPE,'U',R.IMDG_UN_NO,C.IMDG_UN_NO))                     IMDG_UN_NO " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S','',DECODE(R.R_TYPE,'U',R.IMDG_UN_NO_SEQ,C.IMDG_UN_NO_SEQ))             IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("        		 , RT.ORDER_NUM1" ).append("\n"); 
		query.append("                 , RT.ORDER_NUM2" ).append("\n"); 
		query.append("                 , RT.VVD_CD" ).append("\n"); 
		query.append("		      FROM ROUTE_TBL              RT" ).append("\n"); 
		query.append("        		 , PORT_RSTR_TBL1         R " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL LD " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL DD " ).append("\n"); 
		query.append("                 , SCG_IMDG_PORT_RSTR_DTL TD" ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL PD " ).append("\n"); 
		query.append("        		 , PORT_RSTR_TBL2         C " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL LC " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL DC " ).append("\n"); 
		query.append("                 , SCG_IMDG_PORT_RSTR_DTL TC" ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL PC" ).append("\n"); 
		query.append("		     WHERE RT.PORT_CD             = R.PORT_CD(+)" ).append("\n"); 
		query.append("               AND RT.PORT_CD             = C.PORT_CD(+)" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = LD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = LD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND LD.PORT_PROHI_TP_CD(+) = 'L' " ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = DD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = DD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND DD.PORT_PROHI_TP_CD(+) = 'D' " ).append("\n"); 
		query.append("               AND R.PORT_CD              = TD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = TD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND TD.PORT_PROHI_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = PD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = PD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND PD.PORT_PROHI_TP_CD(+) = 'P' " ).append("\n"); 
		query.append("      		 " ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = LC.PORT_CD(+) " ).append("\n"); 
		query.append("      	       AND C.IMDG_PORT_RSTR_SEQ   = LC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND LC.PORT_PROHI_TP_CD(+) = 'L' " ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = DC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = DC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND DC.PORT_PROHI_TP_CD(+) = 'D' " ).append("\n"); 
		query.append("               AND C.PORT_CD              = TC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = TC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND TC.PORT_PROHI_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = PC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = PC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND PC.PORT_PROHI_TP_CD(+) = 'P'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--Un No. 별  Vessel제한사항을 적용한다. -by 이도형(2009.12.28)--" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PORT_TYPE" ).append("\n"); 
		query.append("				 , PORT_CD" ).append("\n"); 
		query.append("				 , IMDG_CMPTN_AUTH_DESC" ).append("\n"); 
		query.append("				 , TXT_DESC" ).append("\n"); 
		query.append("				 , SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("				 , SPCL_CGO_SEQ" ).append("\n"); 
		query.append("				 , IMDG_UN_NO" ).append("\n"); 
		query.append("				 , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("				 , ORDER_NUM1" ).append("\n"); 
		query.append("				 , ORDER_NUM2" ).append("\n"); 
		query.append("                 , VVD_CD" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("				SELECT DECODE(RT.PORT_TYPE,'S','Skip','L','POL','D','POD','T','T/S','Pass') PORT_TYPE " ).append("\n"); 
		query.append("			         , RT.PORT_CD " ).append("\n"); 
		query.append("        			 , DECODE(RT.PORT_TYPE,'S',''," ).append("\n"); 
		query.append("							DECODE(RT.PORT_TYPE,'T'," ).append("\n"); 
		query.append("								DECODE(R.PROHI_TS_FLG,'Y','Prohibition',NULL)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					   ) IMDG_CMPTN_AUTH_DESC" ).append("\n"); 
		query.append("    	        	 , DECODE(RT.PORT_TYPE,'S','',DECODE(RT.PORT_TYPE,'T','SML allow UN No. '||R.IMDG_UN_NO||' only for the direct calling from POL to POD')) TXT_DESC" ).append("\n"); 
		query.append("	    	         , DECODE(RT.PORT_TYPE,'S','',R.SPCL_CNTR_SEQ)             SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("     	    	     , DECODE(RT.PORT_TYPE,'S','',R.SPCL_CGO_SEQ)              SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          			 , DECODE(RT.PORT_TYPE,'S','',R.IMDG_UN_NO)                IMDG_UN_NO" ).append("\n"); 
		query.append("	            	 , DECODE(RT.PORT_TYPE,'S','',R.IMDG_UN_NO_SEQ)            IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    	        	 , RT.ORDER_NUM1" ).append("\n"); 
		query.append("        	    	 , RT.ORDER_NUM2" ).append("\n"); 
		query.append("                     , RT.VVD_CD" ).append("\n"); 
		query.append("				  FROM ROUTE_TBL             RT" ).append("\n"); 
		query.append("	            	 , VSL_RSTR_TBL1         R" ).append("\n"); 
		query.append("				 WHERE RT.PORT_TYPE          = R.PORT_TYPE(+)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			WHERE IMDG_CMPTN_AUTH_DESC IS NOT NULL" ).append("\n"); 
		query.append("			--Un No. 별  Vessel제한사항을 적용한다 끝. -by 이도형(2009.12.28)--" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  ) ST " ).append("\n"); 
		query.append("  ) TT " ).append("\n"); 
		query.append(" WHERE NUM = 1 " ).append("\n"); 
		query.append(" OR IMDG_CMPTN_AUTH_DESC = 'Prohibition'" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       TT.PORT_TYPE" ).append("\n"); 
		query.append("     , TT.PORT_CD" ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_CMPTN_AUTH_DESC,'Permit', 'Restriction',''),TT.IMDG_CMPTN_AUTH_DESC)" ).append("\n"); 
		query.append("	 , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'No Need',TT.IMDG_CMPTN_AUTH_DESC,'Declare',TT.IMDG_CMPTN_AUTH_DESC,'Permit',TT.IMDG_CMPTN_AUTH_DESC,''),DECODE(TT.IMDG_CMPTN_AUTH_DESC, 'Prohibition', '',TT.IMDG_CMPTN_AUTH_DESC))" ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.TXT_DESC,TT.TXT_DESC),TT.TXT_DESC)" ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.SPCL_CNTR_SEQ,'Permit',TT.SPCL_CNTR_SEQ,''),TT.SPCL_CNTR_SEQ)      " ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.SPCL_CGO_SEQ,'Permit',TT.SPCL_CGO_SEQ,''),TT.SPCL_CGO_SEQ)          " ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_UN_NO,'Permit',TT.IMDG_UN_NO,''),TT.IMDG_UN_NO)               " ).append("\n"); 
		query.append("     , DECODE(TT.NUM,1,DECODE(TT.IMDG_CMPTN_AUTH_DESC,'Prohibition',TT.IMDG_UN_NO_SEQ,'Permit',TT.IMDG_UN_NO_SEQ,''),TT.IMDG_UN_NO_SEQ)         " ).append("\n"); 
		query.append("     , TT.ORDER_NUM1" ).append("\n"); 
		query.append("     , TT.ORDER_NUM2" ).append("\n"); 
		query.append("     , TT.VVD_CD" ).append("\n"); 
		query.append(") FT" ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("       FT.ORDER_NUM1" ).append("\n"); 
		query.append("     , FT.ORDER_NUM2" ).append("\n"); 
		query.append("     , FT.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("     , TO_NUMBER(FT.SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("     , FT.IMDG_UN_NO" ).append("\n"); 
		query.append("     , FT.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("	 , FT.TXT_DESC DESC" ).append("\n"); 

	}
}