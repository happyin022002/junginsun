/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInterfaceManageDBDAOGetEDIDTLseqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.24
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.08.24 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInterfaceManageDBDAOGetEDIDTLseqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetEDIDTLseq
	  * </pre>
	  */
	public TESInterfaceManageDBDAOGetEDIDTLseqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_so_dtl_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ").append("\n"); 
		query.append("FileName : TESInterfaceManageDBDAOGetEDIDTLseqRSQL").append("\n"); 
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
		query.append("SELECT D.TML_EDI_SO_DTL_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE D.TML_EDI_SO_OFC_CTY_CD	= @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_EDI_SO_SEQ			= @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND D.EDI_SO_DTL_ID				= @[edi_so_dtl_id]" ).append("\n"); 

	}
}