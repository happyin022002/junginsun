/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopHdrToBeCreatedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopHdrToBeCreatedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * qty 별이 아닌 cop 단건 생성을 위해 select 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopHdrToBeCreatedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopHdrToBeCreatedRSQL").append("\n"); 
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
		query.append("#if (${cop_no} != '') " ).append("\n"); 
		query.append("			 @[cop_no] as cop_no" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              'C'|| c.ofc_cd ||" ).append("\n"); 
		query.append("               SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) ||                                             --2007-04-30:jsahn:cop sequence 변경 Y(1)   " ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'                      --20070430" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'                      --20070430" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'                      --20070430" ).append("\n"); 
		query.append("                    ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1)                                      --20070430 M(1)" ).append("\n"); 
		query.append("               END  ||                                                                              --20070430" ).append("\n"); 
		query.append("               SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) ||                                             --20070430 D(2)" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(SCE_COP_SEQ1.NEXTVAL,'000000'))                                         --20070430 SEQ(6)                      " ).append("\n"); 
		query.append("               as cop_no " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ,@[bkg_no]         as bkg_no" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("		, @[cntr_no] as cntr_no" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		,'SMCU0000000' as cntr_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			, @[cntr_tpsz_cd] as cntr_tpsz_cd" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("		,TO_CHAR(SYSDATE, 'YYYY') AS CNMV_YR" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         ,'' as cnmv_yr" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("             ,case when c.bkg_sts_cd = 'X' then 'X' else 'C' end cop_sts_cd              " ).append("\n"); 
		query.append("             ,c.pctl_no as pctl_no" ).append("\n"); 
		query.append("             ,'' AS MST_COP_NO" ).append("\n"); 
		query.append("             ,c.trnk_vsl_cd as trnk_vsl_Cd" ).append("\n"); 
		query.append("			 ,c.trnk_skd_voy_no as trnk_skd_voy_no" ).append("\n"); 
		query.append("			 ,c.trnk_skd_dir_cd as trnk_skd_dir_cd" ).append("\n"); 
		query.append("             ,c.por_nod_cd as por_nod_Cd" ).append("\n"); 
		query.append("             ,c.pol_nod_cd as pol_nod_cd -- 수정 요망" ).append("\n"); 
		query.append("             ,c.pod_nod_cd as pod_nod_cd -- 수정 요망" ).append("\n"); 
		query.append("             ,c.del_nod_cd as del_nod_cd" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("       FROM  (SELECT case when a.bkg_ofc_cd is not null then SUBSTR(a.bkg_ofc_cd,1,3) else " ).append("\n"); 
		query.append("                        case when h.bkg_ofc_cd is null then SUBSTR( @[bkg_no],1,3 ) else SUBSTR(h.bkg_ofc_cd, 1,3) end " ).append("\n"); 
		query.append("                     end ofc_cd" ).append("\n"); 
		query.append("                    ,0  cop_no_seq" ).append("\n"); 
		query.append("                    ,a.pctl_no" ).append("\n"); 
		query.append("                    ,a.por_nod_cd" ).append("\n"); 
		query.append("                    ,a.pol_nod_cd" ).append("\n"); 
		query.append("                    ,a.pod_nod_cd" ).append("\n"); 
		query.append("                    ,a.del_nod_cd" ).append("\n"); 
		query.append("                    ,a.por_cd" ).append("\n"); 
		query.append("                    ,a.del_cd" ).append("\n"); 
		query.append("					,a.trnk_vsl_cd" ).append("\n"); 
		query.append("					,a.trnk_skd_voy_no" ).append("\n"); 
		query.append("					,a.trnk_skd_dir_cd" ).append("\n"); 
		query.append("					,a.n1st_vsl_lodg_due_dt" ).append("\n"); 
		query.append("	       			,h.bkg_sts_cd" ).append("\n"); 
		query.append("              FROM   prd_prod_ctl_mst a," ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        select bkg_no, bkg_ofc_cd, bkg_sts_cd" ).append("\n"); 
		query.append("                        from bkg_booking" ).append("\n"); 
		query.append("                        where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                      ) h" ).append("\n"); 
		query.append("              WHERE  a.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("                    and h.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("              ) c" ).append("\n"); 

	}
}