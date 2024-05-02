/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ~ 2017/03/27   : Filterd Bkg count
	  * 2017/03/28 ~   : Total Bkg Count (by Application date)
	  * 2017/05/18 ~   : Total Bkg Count (by Port Closing Date)
	  * </pre>
	  */
	public UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rater_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_status_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL").append("\n"); 
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
		query.append("SELECT    COUNT(BK.BKG_NO) AS BKG_COUNT" ).append("\n"); 
		query.append("    FROM      BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_RATE BR" ).append("\n"); 
		query.append("            , BKG_BL_DOC DOC" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("               SELECT  /*+ NO_MERGE */ LVL.* " ).append("\n"); 
		query.append("                 FROM BKG_OFC_LVL_V  LVL " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("                  AND LVL.REGION = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) LVL" ).append("\n"); 
		query.append("    WHERE   BK.BKG_NO            = BR.BKG_NO" ).append("\n"); 
		query.append("    AND     BK.BKG_NO            = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("    AND     BK.POL_CD            = VVD.POL_CD" ).append("\n"); 
		query.append("    AND     BK.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("    AND     VPS.VSL_CD           = VVD.VSL_CD" ).append("\n"); 
		query.append("    AND     VPS.SKD_VOY_NO       = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND     VPS.SKD_DIR_CD       = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND     VPS.CLPT_IND_SEQ     = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND	    VPS.VPS_PORT_CD      = VVD.POL_CD" ).append("\n"); 
		query.append("    AND     BK.BKG_OFC_CD        = LVL.OFC_CD" ).append("\n"); 
		query.append("    AND     BK.BKG_CGO_TP_CD    = 'F'" ).append("\n"); 
		query.append("    AND     BK.PORT_CLZ_DT BETWEEN TO_DATE(@[rt_aply_dt_from],'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    AND     3 = (SELECT COUNT(*) FROM BKG_CUSTOMER WHERE BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD IN ('S', 'C', 'N'))" ).append("\n"); 
		query.append("#if (${rct_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND     BK.BKG_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conti_cd} != '')" ).append("\n"); 
		query.append("    AND     BK.POR_CD  IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CONTI_CD=@[conti_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conti_cd2} != '')" ).append("\n"); 
		query.append("    AND     BK.DEL_CD IN(SELECT LOC_CD FROM MDM_LOCATION WHERE CONTI_CD=@[conti_cd2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("    AND     VVD.VSL_CD		= SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("    AND		VVD.SKD_VOY_NO	= SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("    AND		VVD.SKD_DIR_CD	= SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("    AND     BR.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bdr_status_cd} != '')" ).append("\n"); 
		query.append("    AND 	DOC.BDR_FLG = @[bdr_status_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rater_id} != '')" ).append("\n"); 
		query.append("    AND	    BR.UPD_USR_ID LIKE @[rater_id] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contract_no} != '') " ).append("\n"); 
		query.append("    AND     DECODE(BR.BKG_CTRT_TP_CD, 'T', BK.TAA_NO, 'R', BK.RFA_NO, 'S', BK.SC_NO) = @[contract_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}