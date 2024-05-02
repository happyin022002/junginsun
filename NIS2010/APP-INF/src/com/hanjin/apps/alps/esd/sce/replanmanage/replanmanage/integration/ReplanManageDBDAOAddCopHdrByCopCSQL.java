/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ReplanManageDBDAOAddCopHdrByCopCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.23 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOAddCopHdrByCopCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP 단위로 SCE_COP_HDR 정보를 생성한다.(qty 단위로 복수개를 생성하지 않고 단건의 COP HEADER 를 생성함)
	  * </pre>
	  */
	public ReplanManageDBDAOAddCopHdrByCopCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_rail_chk_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOAddCopHdrByCopCSQL").append("\n"); 
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
		query.append("INSERT INTO sce_cop_hdr" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            COP_NO," ).append("\n"); 
		query.append("            BKG_NO," ).append("\n"); 
		query.append("            CNTR_NO," ).append("\n"); 
		query.append("            CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            CNMV_YR," ).append("\n"); 
		query.append("            COP_STS_CD," ).append("\n"); 
		query.append("            PCTL_NO," ).append("\n"); 
		query.append("            MST_COP_NO," ).append("\n"); 
		query.append("            TRNK_VSL_CD," ).append("\n"); 
		query.append("            TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("            TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("            POR_NOD_CD," ).append("\n"); 
		query.append("            POL_NOD_CD," ).append("\n"); 
		query.append("            POD_NOD_CD," ).append("\n"); 
		query.append("            DEL_NOD_CD," ).append("\n"); 
		query.append("			COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("			OB_TRO_FLG," ).append("\n"); 
		query.append("			IB_TRO_FLG," ).append("\n"); 
		query.append("			RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("			RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT            " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("              @[cop_no]			as cop_no" ).append("\n"); 
		query.append("             ,@[bkg_no]         as bkg_no" ).append("\n"); 
		query.append("             ,@[cntr_no]     as cntr_no" ).append("\n"); 
		query.append("             ,@[cntr_tpsz_cd] as cntr_tpsz_cd" ).append("\n"); 
		query.append("             ,to_char(sysdate, 'yyyy') as cnmv_yr" ).append("\n"); 
		query.append("             ,case when c.bkg_sts_cd = 'X' then 'X' else 'C' end cop_sts_cd              " ).append("\n"); 
		query.append("             ,c.pctl_no" ).append("\n"); 
		query.append("             ,@[cop_no] AS MST_COP_NO" ).append("\n"); 
		query.append("             ,c.trnk_vsl_cd" ).append("\n"); 
		query.append("			 ,c.trnk_skd_voy_no" ).append("\n"); 
		query.append("			 ,c.trnk_skd_dir_cd" ).append("\n"); 
		query.append("             ,c.por_nod_cd" ).append("\n"); 
		query.append("             ,c.pol_nod_cd" ).append("\n"); 
		query.append("             ,c.pod_nod_cd" ).append("\n"); 
		query.append("             ,c.del_nod_cd" ).append("\n"); 
		query.append("			 ,@[cop_rail_chk_cd]" ).append("\n"); 
		query.append("			 ,nvl(@[ob_tro_flg], 'N')" ).append("\n"); 
		query.append("			 ,NVL(@[ib_tro_flg], 'N')" ).append("\n"); 
		query.append("			 ,TO_DATE(@[rail_rcv_coff_fm_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("			 ,TO_DATE(@[rail_rcv_coff_to_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("			 ,'SYSTEM'" ).append("\n"); 
		query.append("			 ,sysdate" ).append("\n"); 
		query.append("			 ,'SYSTEM'" ).append("\n"); 
		query.append("			 ,sysdate                  " ).append("\n"); 
		query.append("       FROM  (SELECT case when a.bkg_ofc_cd is not null then SUBSTR(a.bkg_ofc_cd,1,3) else " ).append("\n"); 
		query.append("                        case when h.bkg_ofc_cd is null then SUBSTR( @[bkg_no],1,3 ) else SUBSTR(h.bkg_ofc_cd, 1, 3) end " ).append("\n"); 
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