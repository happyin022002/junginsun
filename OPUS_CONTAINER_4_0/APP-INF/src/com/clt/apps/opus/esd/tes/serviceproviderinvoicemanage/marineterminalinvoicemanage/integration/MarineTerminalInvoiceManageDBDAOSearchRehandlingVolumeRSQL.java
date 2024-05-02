/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchRehandlingVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.10
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.10 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchRehandlingVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRehandlingVolume
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchRehandlingVolumeRSQL(){
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchRehandlingVolumeRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO RVIS_CNTR_NO," ).append("\n"); 
		query.append("A.RHND_RSN_CD RVIS_RHND_RSN_CD," ).append("\n"); 
		query.append("A.CUZ_CNTR_NO RVIS_CUZ_CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD RVIS_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.RVIS_IND_FLG," ).append("\n"); 
		query.append("A.TML_SO_DTL_SEQ RVIS_TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("A.TML_SO_RVIS_LIST_SEQ RVIS_TML_SO_RVIS_LIST_SEQ," ).append("\n"); 
		query.append("A.LGS_COST_CD RVIS_LGS_COST_CD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT CD.CNTR_NO," ).append("\n"); 
		query.append("CD.SHIFT_RSN  RHND_RSN_CD," ).append("\n"); 
		query.append("'' CUZ_CNTR_NO," ).append("\n"); 
		query.append("RL.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(RL.CNTR_NO, NULL, '0','1') RVIS_IND_FLG," ).append("\n"); 
		query.append("RL.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("RL.TML_SO_RVIS_LIST_SEQ," ).append("\n"); 
		query.append("RL.LGS_COST_CD" ).append("\n"); 
		query.append("FROM   TDR_CNTR_DETAIL CD, TES_TML_SO_RVIS_LIST RL" ).append("\n"); 
		query.append("WHERE  TRIM(CD.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("AND    CD.VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    CD.VOY_NO		= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    CD.DIR_CD		= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    CD.PORT_CD		= SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("AND    DECODE(@[cntr_tpsz_cd],'','X',@[cntr_tpsz_cd]) = DECODE(@[cntr_tpsz_cd],'','X',CD.sztp)" ).append("\n"); 
		query.append("AND    CD.VSL_CD     	= RL.VSL_CD(+)" ).append("\n"); 
		query.append("AND    CD.VOY_NO 		= RL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    CD.DIR_CD 		= RL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    CD.CNTR_NO 		= RL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    @[tml_so_seq] 	= RL.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("AND    @[tml_so_ofc_cty_cd] = RL.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    @[lgs_cost_cd] = RL.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND    NVL(@[tml_so_dtl_seq],0) = RL.TML_SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT R.CNTR_NO," ).append("\n"); 
		query.append("R.RHND_RSN_CD," ).append("\n"); 
		query.append("R.CUZ_CNTR_NO," ).append("\n"); 
		query.append("R.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(R.CNTR_NO, NULL, '0','1') RVIS_IND_FLG," ).append("\n"); 
		query.append("R.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("R.TML_SO_RVIS_LIST_SEQ," ).append("\n"); 
		query.append("R.LGS_COST_CD" ).append("\n"); 
		query.append("FROM TES_TML_SO_RVIS_LIST R" ).append("\n"); 
		query.append("WHERE  R.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    R.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND    R.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("AND    R.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    R.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    R.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    R.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND    DECODE(@[cntr_tpsz_cd],'','X',@[cntr_tpsz_cd]) = DECODE(@[cntr_tpsz_cd],'','X',R.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("ORDER BY  A.CNTR_NO" ).append("\n"); 

	}
}