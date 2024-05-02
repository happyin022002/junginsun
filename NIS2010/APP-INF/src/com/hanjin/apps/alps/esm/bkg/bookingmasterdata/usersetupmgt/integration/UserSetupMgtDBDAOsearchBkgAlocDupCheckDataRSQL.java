/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Allocation Duplication Check
	  * </pre>
	  */
	public UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_del_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_ts_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_ts_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL").append("\n"); 
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
		query.append("SELECT  'Type : '||" ).append("\n"); 
		query.append("	    (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("        WHERE BKG_ALOC_TP_CD = INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("        AND INTG_CD_ID = 'CD03267')|| ' ' ||" ).append("\n"); 
		query.append("	    DECODE(BKG_ALOC_TP_CD,'T',', T.Lane : '|| TRNK_SLAN_CD,'') ||" ).append("\n"); 
		query.append("        DECODE(BKG_ALOC_TP_CD,'S',', T/S Lane : '|| N1ST_TS_SLAN_CD ,'') || " ).append("\n"); 
		query.append("        DECODE(BKG_ALOC_TP_CD,'E',', Cntr Type : '|| CNTR_TPSZ_CD,'') ||" ).append("\n"); 
		query.append("        DECODE(BKG_ALOC_TP_CD,'M',', Commodity : '|| NVL(CMDT_CD,SCG_GRP_CMDT_SEQ),'') || " ).append("\n"); 
		query.append("        DECODE(BKG_ALOC_TP_CD,'C',', SC No / RFA No / Contract Code / Shipper Code : '" ).append("\n"); 
		query.append("                                || SC_NO || ' / ' || RFA_NO || ' / ' || CTRT_CUST_CNT_CD||CTRT_CUST_SEQ || ' / ' || CUST_CNT_CD||CUST_SEQ,'') BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("FROM BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("WHERE BKG_ALOC_TP_CD =  @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("AND BKG_ALOC_SEQ <> NVL(@[bkg_aloc_seq],0)" ).append("\n"); 
		query.append("AND NVL(TRNK_SLAN_CD    ,'NULL') = NVL(@[trnk_slan_cd]                   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(TRNK_DIR_CD     ,'NULL') = NVL(@[trnk_dir_cd]                    ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(VSL_CD			,'NULL') = NVL(SUBSTR(@[vvd],1,4)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SKD_VOY_NO		,'NULL') = NVL(SUBSTR(@[vvd],5,4)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SKD_DIR_CD		,'NULL') = NVL(SUBSTR(@[vvd],9,1)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SLS_RHQ_CD		,'NULL') = NVL(@[sls_rhq_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(OB_SLS_OFC_CD	,'NULL') = NVL(@[ob_sls_ofc_cd]                  ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_POR_CNT_CD  ,'NULL') = NVL(@[bkg_por_cnt_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POR_CD          ,'NULL') = NVL(@[por_cd]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POR_NOD_CD      ,'NULL') = NVL(@[por_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_POR_SCC_CD  ,'NULL') = NVL(@[bkg_por_scc_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_POL_CNT_CD  ,'NULL') = NVL(@[bkg_pol_cnt_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POL_CD          ,'NULL') = NVL(@[pol_cd]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POL_NOD_CD      ,'NULL') = NVL(@[pol_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(N1ST_TS_SLAN_CD ,'NULL') = NVL(@[n1st_ts_slan_cd]                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_POD_CNT_CD  ,'NULL') = NVL(@[bkg_pod_cnt_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POD_CD          ,'NULL') = NVL(@[pod_cd]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POD_NOD_CD      ,'NULL') = NVL(@[pod_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_DEL_CNT_CD  ,'NULL') = NVL(@[bkg_del_cnt_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(DEL_CD          ,'NULL') = NVL(@[del_cd]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(DEL_NOD_CD      ,'NULL') = NVL(@[del_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_DEL_SCC_CD  ,'NULL') = NVL(@[bkg_del_scc_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SC_NO           ,'NULL') = NVL(@[sc_no]                          ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(RFA_NO          ,'NULL') = NVL(@[rfa_no]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CTRT_CUST_CNT_CD,'NULL') = NVL(SUBSTR(@[ctrt_cust_cnt_cd],1,2)   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CTRT_CUST_SEQ   ,0)      = NVL(SUBSTR(@[ctrt_cust_cnt_cd],3)     ,0)  " ).append("\n"); 
		query.append("AND NVL(CUST_CNT_CD     ,'NULL') = NVL(SUBSTR(@[cust_cnt_cd],1,2)        ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CUST_SEQ        ,0)      = NVL(SUBSTR(@[cust_cnt_cd],3)          ,0)  " ).append("\n"); 
		query.append("AND NVL(CNTR_TPSZ_CD    ,'NULL') = NVL(@[cntr_tpsz_cd]                   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CMDT_CD         ,'NULL') = NVL(TRIM(TO_CHAR(@[cmdt_cd],'000000')),'NULL')" ).append("\n"); 
		query.append("AND NVL(N1ST_TS_DIR_CD  ,'NULL') = NVL(@[n1st_ts_dir_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(N1ST_TS_POL_CNT_CD,'NULL') = NVL(@[n1st_ts_pol_cnt_cd]           ,'NULL')" ).append("\n"); 
		query.append("AND NVL(N1ST_TS_POD_CNT_CD,'NULL') = NVL(@[n1st_ts_pod_cnt_cd]           ,'NULL')" ).append("\n"); 
		query.append("AND NVL(SCG_GRP_CMDT_SEQ,0)      = NVL(TO_NUMBER(@[scg_grp_cmdt_seq])	             ,0)" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'T'),'NULL') = NVL(@[trunk_pol_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'T'),'NULL') = NVL(@[trunk_pod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'S'),'NULL') = NVL(@[n1st_ts_pol_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'S'),'NULL') = NVL(@[n1st_ts_pod_cd],'NULL')" ).append("\n"); 

	}
}