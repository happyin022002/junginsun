/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCmdtByScRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.11.25 Hyunhwa Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCmdtByScRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C 계약 상의 Commodity를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCmdtByScRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCmdtByScRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    DISTINCT Y.PRC_GRP_CMDT_CD AS prc_cmdt_def_cd," ).append("\n"); 
		query.append("    MDM.CMDT_NM AS cmdt_nm," ).append("\n"); 
		query.append("    (SELECT SVC_SCP_NM FROM MDM_SVC_SCP WHERE SVC_SCP_CD = Y.SVC_SCP_CD) scope_name," ).append("\n"); 
		query.append("    cmdt_cd," ).append("\n"); 
		query.append("    rep_cmdt_cd," ).append("\n"); 
		query.append("    Y.svc_scp_cd" ).append("\n"); 
		query.append("     FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    /* 그룹만 가져와서 비교 */" ).append("\n"); 
		query.append("    SELECT DTL.PRC_CMDT_DEF_CD, CMDT.PRC_GRP_CMDT_CD, DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_GRP_CMDT CMDT, " ).append("\n"); 
		query.append("    PRI_SP_SCP_MN MN, " ).append("\n"); 
		query.append("    PRI_SP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND CMDT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND CMDT.AMDT_SEQ =  @[amdt_seq]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} !='')" ).append("\n"); 
		query.append("    AND CMDT.SVC_SCP_CD = SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND CMDT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND CMDT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("    AND CMDT.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT.PROP_NO = DTL.PROP_NO" ).append("\n"); 
		query.append("    AND CMDT.AMDT_SEQ = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("    AND CMDT.SVC_SCP_CD = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT.GRP_CMDT_SEQ = DTL.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    and dtl.prc_cmdt_tp_cd = 'C'" ).append("\n"); 
		query.append("    #if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("    AND DTL.PRC_CMDT_DEF_CD  LIKE @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    /* 개별은 업무상 그룹LIST 에 있는것만 가질수 있으므로 PRC_CMDT_TP_CD ='C' 만 가져옴  */" ).append("\n"); 
		query.append("    SELECT  A.PRC_CMDT_DEF_CD, A.PRC_CMDT_DEF_CD, A.SVC_SCP_CD FROM PRI_SP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} !='')" ).append("\n"); 
		query.append("    AND A.SVC_SCP_CD = SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.PRC_CMDT_TP_CD ='C'" ).append("\n"); 
		query.append("    #if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("    AND A.PRC_CMDT_DEF_CD  LIKE @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ) Y , MDM_COMMODITY MDM" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND Y.PRC_CMDT_DEF_CD = MDM.CMDT_CD" ).append("\n"); 
		query.append("    #if (${cmdt_nm} != '') " ).append("\n"); 
		query.append("    AND CMDT_NM  like '%'||@[cmdt_nm]||'%'" ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("    ORDER BY PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}